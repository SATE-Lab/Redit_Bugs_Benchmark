package io.redit.samples.kafka13852;

import io.redit.ReditRunner;
import io.redit.exceptions.RuntimeEngineException;
import io.redit.execution.CommandResults;
import io.redit.helpers.KafkaHelper;
import io.redit.helpers.ZookeeperHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.concurrent.TimeoutException;

public class SampleTest {
    private static final Logger logger = LoggerFactory.getLogger(SampleTest.class);
    protected static ReditRunner runner;
    private static ZookeeperHelper zookeeperHelper;
    private static KafkaHelper kafkaHelper;
    private static String emptyDirName = "test_empty";
    private static String notEmptyDirName = "test_not_empty";
    private static String fileName = "test.txt";

    @BeforeClass
    public static void before() throws RuntimeEngineException, IOException, InterruptedException {
        runner = ReditRunner.run(ReditHelper.getDeployment());
        ReditHelper.startNodes(runner);
        zookeeperHelper = new ZookeeperHelper(runner, ReditHelper.getZookeeperHomeDir(), logger, ReditHelper.getZookeeperFileRW(), ReditHelper.numOfServers);
        zookeeperHelper.addConfFile();
        kafkaHelper = new KafkaHelper(runner, ReditHelper.getKafkaHomeDir(), logger, ReditHelper.getKafkaFileRW(), ReditHelper.numOfServers, "");
        kafkaHelper.addKafkaPropFile();

        zookeeperHelper.startServers();
        Thread.sleep(5000);
        zookeeperHelper.checkServersStatus();
        kafkaHelper.startKafkas();
        Thread.sleep(5000);
        kafkaHelper.checkJps();
    }

    @AfterClass
    public static void after() {
        if (runner != null) {
            runner.stop();
        }
    }

    @Test
    public void sampleTest() throws InterruptedException, RuntimeEngineException, TimeoutException {
        runner.runtime().enforceOrder("E1", () -> {
            makeDirs(1);
        });
        Thread.sleep(2000);

        runner.runtime().enforceOrder("E2", () -> {
            addAcl(1, notEmptyDirName);
        });

        runner.runtime().enforceOrder("E3", () -> {
            addAcl(1, emptyDirName);
        });

        runner.runtime().enforceOrder("E4", () -> {
            checkAcl(1, notEmptyDirName);
        });

        runner.runtime().enforceOrder("E5", () -> {
            checkAcl(1, emptyDirName);
        });

        runner.runtime().waitForRunSequenceCompletion(20);
        logger.info("completed !!!");
    }

    private void makeDirs(int serverId) throws RuntimeEngineException {
        String command = "cd " + ReditHelper.getKafkaHomeDir() + " && mkdir " + emptyDirName + " " + notEmptyDirName +
                " && touch " + notEmptyDirName + "/" + fileName;
        logger.info("server" + serverId + " make test Dirs ...");
        runner.runtime().runCommandInNode("server" + serverId, command);
    }

    private void addAcl(int serverId, String dirName) throws RuntimeEngineException {
        String command = "cd " + ReditHelper.getKafkaHomeDir() + "/" + dirName +
                " && ../bin/kafka-acls.sh --authorizer-properties zookeeper.connect=" + zookeeperHelper.connectionStr + " --add --allow-principal User:Peter --allow-host 198.51.200.1 --producer --topic '*'";
        logger.info("server" + serverId + " add an Acl in " + dirName);
        CommandResults commandResults = runner.runtime().runCommandInNode("server" + serverId, command);
        kafkaHelper.printResult(commandResults);
    }

    private void checkAcl(int serverId, String dirName) throws RuntimeEngineException {
        String command = "cd " + ReditHelper.getKafkaHomeDir() + "/" + dirName +
                " && ../bin/kafka-acls.sh --authorizer-properties zookeeper.connect=" + zookeeperHelper.connectionStr + " --list --topic '*'";
        logger.info("server" + serverId + " check file Acl in "  + dirName);
        CommandResults commandResults = runner.runtime().runCommandInNode("server" + serverId, command);
        kafkaHelper.printResult(commandResults);
    }
}