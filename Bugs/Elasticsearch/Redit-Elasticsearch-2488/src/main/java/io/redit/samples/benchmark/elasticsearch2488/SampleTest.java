package io.redit.samples.benchmark.elasticsearch2488;

import io.redit.ReditRunner;
import io.redit.exceptions.RuntimeEngineException;
import io.redit.helpers.ElasticsearchHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeoutException;

public class SampleTest {
    private static final Logger logger = LoggerFactory.getLogger(SampleTest.class);
    private static ReditRunner runner;
    private static ElasticsearchHelper helper;
    private String masterServer;
    private ArrayList<String> serverList = new ArrayList<>();
    private String followerName;
    private String followerIp;

    @BeforeClass
    public static void before() throws RuntimeEngineException, IOException, InterruptedException {
        runner = ReditRunner.run(ReditHelper.getDeployment());
        ReditHelper.startNodes(runner);
        helper = new ElasticsearchHelper(runner, ReditHelper.getElasticsearchHomeDir(), logger, ReditHelper.getFileRW(), ReditHelper.numOfServers);
        helper.addElasticsearchYmlFile();

        helper.startServers();
        helper.checkJps();
    }

    @AfterClass
    public static void after() {
        if (runner != null) {
            runner.stop();
        }
    }

    @Test
    public void testSplitBrainIfSplitsAreIntersecting() throws RuntimeEngineException, TimeoutException {
        runner.runtime().enforceOrder("E1", () -> {
            refreshMasterServer();
        });

        // 筛选出非master的两台服务器
        runner.runtime().enforceOrder("E2", () -> {
            assert masterServer != null;
            for (int i = 1; i <= ReditHelper.numOfServers; i++) {
                String serverName = "server" + i;
                if (!serverName.equals(this.masterServer)) {
                    serverList.add(serverName);
                }
            }
        });

        // 随机选择出将要与master断开连接的服务器，命名为follower
        runner.runtime().enforceOrder("E3", () -> {
            followerName = serverList.get(new Random().nextInt(2));
            followerIp = runner.runtime().ip(followerName);
            logger.info("master server: " + this.masterServer + "; Ip address: " + runner.runtime().ip(this.masterServer));
            logger.info("follower server: " + followerName + "; Ip address: " + followerIp);
            logger.info("blocking network between " + this.masterServer + " and " + followerName);
        });

        // 断开master和follower的连接，若该follower选举自己为master，则可以复现bug，否则需要重试
        runner.runtime().enforceOrder("X1", () -> {
            runner.runtime().runCommandInNode(this.masterServer, String.format("iptables -I INPUT -s %s -j DROP", followerIp));
        });

        // 成功触发bug,向master和认为自己是master的follower询问当前master ip时，得到不同答复
        runner.runtime().enforceOrder("E4", () -> {
            boolean successful_trigger = false; // 本轮测试是否触发bug（master选举有随机性，某些情况下无法触发bug）
            try {
                for (int i = 0; i < 6; i++) {
                    Thread.sleep(2000);
                    successful_trigger = checkAllServiceStatus();
                    if(!successful_trigger){
                        logger.info("This round of testing did not trigger bugs, please try again~");
                    }
                }
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (successful_trigger){
                helper.printResult(runner.runtime().runCommandInNode(this.masterServer, "curl localhost:9200/_cat/master?v"));
                helper.printResult(runner.runtime().runCommandInNode(followerName, "curl localhost:9200/_cat/master?v"));
            }
        });

        runner.runtime().waitForRunSequenceCompletion(20);
        logger.info("completed !!!");
    }

    private void refreshMasterServer() throws RuntimeEngineException {
        String command = "curl localhost:9200/_cat/master";
        String commandResult = runner.runtime().runCommandInNode("server1", command).stdOut();
        assert commandResult != null && commandResult.length() != 0;
        String[] commandResList = commandResult.split("\\s");
        for (String s : commandResList) {
            if (s.startsWith("server")) {
                this.masterServer = s;
                logger.info("Current master: " + s + ". Ip address: " + runner.runtime().ip(s));
            }
        }
    }

    private boolean checkAllServiceStatus() throws RuntimeEngineException {
        String cmd = "curl  http://localhost:9200/?pretty";
        for (int i = 1; i < ReditHelper.numOfServers + 1; i++) {
            String cmdRes = runner.runtime().runCommandInNode("server" + i, cmd).stdOut();
            // 若另外一个服务器，也就是直接和master相连的follower选举为master，则会出现503的情况，据此判断测试是否触发bug
            if(cmdRes.contains("503")){
                System.out.println(cmdRes);
                return false;
            }
        }
        return true;
    }




}
