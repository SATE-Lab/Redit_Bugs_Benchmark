package io.redit.samples.benchmark.elasticsearch19269;

import io.redit.ReditRunner;
import io.redit.exceptions.RuntimeEngineException;
import io.redit.execution.CommandResults;
import io.redit.execution.NetPart;
import io.redit.helpers.ElasticsearchHelper;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.concurrent.TimeoutException;

public class SampleTest {
    private static final Logger logger = LoggerFactory.getLogger(SampleTest.class);
    protected static ReditRunner runner;
    private static ElasticsearchHelper helper;
    private String masterServer;
    private final String createIndexCmd = "curl  -XPUT 'localhost:9200/foo?pretty'";
    private final String queryIndexCmd = "curl 'localhost:9200/_cat/indices?v'";
    private final String createDocCmd = "curl -XPUT 'localhost:9200/foo/bar/1?pretty' -d '{ \"value\": \"origin\" }'";
    private final String updateDocCmd1 = "curl --connect-timeout 5 -m 5 -XPOST 'localhost:9200/foo/bar/1/_update?pretty' -d '{\"doc\": { \"value\": \"dirty value\" }}'";
    private final String updateDocCmd2 = "curl --connect-timeout 5 -m 5 -XPOST 'localhost:9200/foo/bar/1/_update?pretty' -d '{\"doc\": { \"value\": \"something else\" }}'";
    private final String queryShardCmd = "curl localhost:9200/_cat/shards";
    private String primaryShardServer = null;
    private String replicaShardServer = null;
    private NetPart netPart;

    @BeforeClass
    public static void before() throws RuntimeEngineException, IOException, InterruptedException {
        runner = ReditRunner.run(ReditHelper.getDeployment());
        ReditHelper.startNodes(runner);
        helper = new ElasticsearchHelper(runner, ReditHelper.getElasticsearchHomeDir(), logger, ReditHelper.getFileRW(), ReditHelper.numOfServers);
        helper.addElasticsearchYmlFile_230();

        helper.startServers_230();
        helper.checkJps();
    }

    @AfterClass
    public static void after() {
        if (runner != null) {
            runner.stop();
        }
    }

    @Test
    public void testVersionDoesNotUniquely() throws InterruptedException, RuntimeEngineException, TimeoutException {
        runner.runtime().enforceOrder("E1", () -> {
            helper.checkElasticsearchStatus();
        });

        runner.runtime().enforceOrder("E2", () -> {
            refreshMasterServer();
        });

        runner.runtime().enforceOrder("E3", () -> {
            helper.printResult(runner.runtime().runCommandInNode("server1", createIndexCmd));
            helper.printResult(runner.runtime().runCommandInNode("server1", queryIndexCmd));
            helper.printResult(runner.runtime().runCommandInNode("server1", createDocCmd));
        });
        Thread.sleep(5000);

        // ????????????????????????server
        runner.runtime().enforceOrder("E4", () -> {
            String shardStr = getCommandResult(runner.runtime().runCommandInNode("server1", queryShardCmd));
            logger.info("shardInfo: \n" + shardStr);
            String[] shardStrList = shardStr.split("\n");
            for (String shardInfo : shardStrList) {
                if (shardInfo.contains(" p ")) {
                    String[] primaryShardInfoList = shardInfo.trim().split(" ");
                    String primaryShardNodeName = primaryShardInfoList[primaryShardInfoList.length - 1];
                    String primaryShardIpAddress = primaryShardInfoList[primaryShardInfoList.length - 2];
                    primaryShardServer = "server" + primaryShardNodeName.substring(primaryShardNodeName.length() - 1);
                    logger.info(String.format("PrimaryShardServer: %s; Ip address: %s", primaryShardServer, primaryShardIpAddress));
                }
            }
            assert primaryShardServer != null && primaryShardServer.length() != 0;
        });

        // ????????????primary shard??????????????????
        runner.runtime().enforceOrder("E5", () -> {
            for (int i = 1; i <= ReditHelper.numOfServers; i++) {
                String serverName = "server" + i;
                if (!serverName.equals(primaryShardServer) && !serverName.equals(this.masterServer)) {
                    replicaShardServer = serverName;
                }
            }
        });

        // ??????????????????
        runner.runtime().enforceOrder("X1", () -> {
            netPart = NetPart.partitions(primaryShardServer, this.masterServer + "," + replicaShardServer).build();
            logger.info("--> start disrupting network");
            runner.runtime().networkPartition(netPart);
        });
        Thread.sleep(3000);

        // ???primaryShardServer???????????????????????????,??????????????????dirty value???
        runner.runtime().enforceOrder("E6", () -> {
            helper.printResult(runner.runtime().runCommandInNode(primaryShardServer, updateDocCmd1));
            boolean dirtyReadSuccess;
            try {
                dirtyReadSuccess = attemptToGetQueryResponse(primaryShardServer);
                if(!dirtyReadSuccess){
                    Assert.fail("dirty read failed (first read failed)");
                }
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // ??????????????????????????????master????????????
        runner.runtime().enforceOrder("E7", () -> {
            helper.printResult(runner.runtime().runCommandInNode(this.masterServer, updateDocCmd2));
        });

        // ??????????????????
        runner.runtime().enforceOrder("X2", () -> {
            logger.info("--> remove disrupting network");
            runner.runtime().removeNetworkPartition(netPart);
        });
        Thread.sleep(3000);

        // ?????????????????????
        runner.runtime().enforceOrder("E8", () -> {
            boolean secondReadSuccess;
            try {
                secondReadSuccess = attemptToGetQueryResponse(this.masterServer);
                if(!secondReadSuccess){
                    Assert.fail("second read failed");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        runner.runtime().waitForRunSequenceCompletion(20);
        logger.info("completed !!!");
    }

    private void refreshMasterServer() throws RuntimeEngineException {
        String command = "curl localhost:9200/_cat/master";
        String commandResult = getCommandResult(runner.runtime().runCommandInNode("server1", command));
        assert commandResult != null && commandResult.length() != 0;
        String[] commandResList = commandResult.split("\\s");
        for (String s : commandResList) {
            if (s.startsWith("node")) {
                this.masterServer = "server" + s.substring(s.length() - 1);
                logger.info("Current master: " + s + ". Ip address: " + runner.runtime().ip(this.masterServer));
            }
        }
        assert this.masterServer.equals("server1");
    }

    private boolean attemptToGetQueryResponse(String serverName) throws RuntimeEngineException, InterruptedException {
        String queryDocCmd = "curl --connect-timeout 5 -m 5 -XGET 'localhost:9200/foo/bar/1?pretty'";
        int maxAttempt = 5;
        for (int i = 1; i <= maxAttempt; i++) { // ????????????????????????????????????????????????????????????????????????
            String queryDocCmdRes  = getCommandResult(runner.runtime().runCommandInNode(serverName, queryDocCmd));
            if(queryDocCmdRes.contains("_version")){
                logger.info(queryDocCmdRes);
                return true;
            }
            Thread.sleep(500);
        }
        return false;
    }

    private static String getCommandResult(CommandResults commandResults) {
        if (commandResults.stdOut() != null && commandResults.stdOut().length() != 0) {
            return commandResults.stdOut();
        } else {
            return commandResults.stdErr();
        }
    }
}
