package io.redit.samples.hdfs13998;

import io.redit.ReditRunner;
import io.redit.exceptions.RuntimeEngineException;
import io.redit.execution.CommandResults;
import io.redit.helpers.HdfsHelper;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.ErasureCodingPolicy;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class SampleTest {
    private static final Logger logger = LoggerFactory.getLogger(SampleTest.class);
    protected static ReditRunner runner;
    private static HdfsHelper helper;
    private static DistributedFileSystem dfs;
    private static final String policy = "RS-6-3-1024k";
    private static final String test1_path = "/test1_ec";
    private static final String test1_replicaPath = "/test1_ec/replica";
    private static final String test2_path = "/test2_ec";
    private static final String test2_filePath = "/test2_ec/file";

    @BeforeClass
    public static void before() throws RuntimeEngineException, IOException, InterruptedException {
        runner = ReditRunner.run(ReditHelper.getDeployment());
        ReditHelper.startNodes(runner);
        helper = new HdfsHelper(runner, ReditHelper.getHadoopHomeDir(), logger, ReditHelper.numOfServers);

        helper.waitActive();
        logger.info("The cluster is UP!");
        helper.transitionToActive(1, runner);
        helper.checkNNs(runner);
        dfs = helper.getDFS(runner);
    }

    @AfterClass
    public static void after() {
        if (runner != null) {
            runner.stop();
        }
    }

    @Test
    public void sampleTest1() throws RuntimeEngineException, IOException {

        logger.info("Test1: set replication policy and check command output" );
        runner.runtime().runCommandInNode("nn1", ReditHelper.getHadoopHomeDir() + "/bin/hdfs dfs -mkdir " + test1_path);
        CommandResults setPolicy = runner.runtime().runCommandInNode("nn1", ReditHelper.getHadoopHomeDir() + "/bin/hdfs ec -setPolicy -policy " + policy + " -path " + test1_path);
        logger.info(setPolicy.command() + " : " + setPolicy.stdOut());
        runner.runtime().runCommandInNode("nn1", ReditHelper.getHadoopHomeDir() + "/bin/hdfs dfs -mkdir " + test1_replicaPath);
        CommandResults setReplicate  = runner.runtime().runCommandInNode("nn1", ReditHelper.getHadoopHomeDir() + "/bin/hdfs ec -setPolicy -replicate -path " + test1_replicaPath);
        logger.info(setReplicate.command() + " : " + setReplicate.stdOut());

        ErasureCodingPolicy path_ecPolicyName = dfs.getErasureCodingPolicy(new Path(test1_path));
        ErasureCodingPolicy replica_ecPolicyName = dfs.getErasureCodingPolicy(new Path(test1_replicaPath));
        logger.info("Get erasure coding policy in " + test1_path + " : " + path_ecPolicyName);
        logger.info("Get erasure coding policy in " + test1_replicaPath + " : " + replica_ecPolicyName);
    }

    @Test
    public void sampleTest2() throws RuntimeEngineException, IOException {

        logger.info("Test2: set replication policy on non-empty directory and check command output" );
        runner.runtime().runCommandInNode("nn1", ReditHelper.getHadoopHomeDir() + "/bin/hdfs dfs -mkdir " + test2_path);
        CommandResults setPolicy = runner.runtime().runCommandInNode("nn1", ReditHelper.getHadoopHomeDir() + "/bin/hdfs ec -setPolicy -policy " + policy + " -path " + test2_path);
        logger.info(setPolicy.command() + " : " + setPolicy.stdOut());

        ErasureCodingPolicy path_ecPolicyName1 = dfs.getErasureCodingPolicy(new Path(test2_path));
        logger.info("Before set replication policy, get erasure coding policy in " + test2_path + " : " + path_ecPolicyName1);

        runner.runtime().runCommandInNode("nn1", ReditHelper.getHadoopHomeDir() + "/bin/hdfs dfs -touch " + test2_filePath);
        CommandResults setReplicate2  = runner.runtime().runCommandInNode("nn1", ReditHelper.getHadoopHomeDir() + "/bin/hdfs ec -setPolicy -replicate -path " + test2_path);
        logger.info(setReplicate2.command() + " : " + setReplicate2.stdOut());

        ErasureCodingPolicy path_ecPolicyName2 = dfs.getErasureCodingPolicy(new Path(test2_path));
        logger.info("After set replication policy, get erasure coding policy in " + test2_path + " : " + path_ecPolicyName2);

        ErasureCodingPolicy filepath_ecPolicyName = dfs.getErasureCodingPolicy(new Path(test2_filePath));
        logger.info("Get erasure coding policy in " + test2_filePath + " : " + filepath_ecPolicyName);

    }
}