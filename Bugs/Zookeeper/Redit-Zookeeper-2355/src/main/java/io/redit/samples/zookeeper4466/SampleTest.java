package io.redit.samples.zookeeper4466;

import io.redit.ReditRunner;
import io.redit.exceptions.RuntimeEngineException;
import io.redit.execution.NetPart;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.redit.helpers.ZookeeperHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertNull;

public class SampleTest {
    private static final Logger logger = LoggerFactory.getLogger(SampleTest.class);
    protected static ReditRunner runner;
    private static ZookeeperHelper helper;
    private static ZooKeeper[] zooKeeper = {null, null, null};
    private static NetPart netPart = null;
    private static String nodePath = "/e1";

    @BeforeClass
    public static void before() throws RuntimeEngineException, IOException, InterruptedException {
        runner = ReditRunner.run(ReditHelper.getDeployment());
        ReditHelper.startNodes(runner);
        helper = new ZookeeperHelper(runner, ReditHelper.getZookeeperHomeDir(), logger, ReditHelper.getFileRW(), ReditHelper.numOfServers);
        helper.addConfFile();
        logger.info("wait for zookeeper...");
        helper.startServers();
        Thread.sleep(5000);
        helper.checkServersStatus();
    }

    @AfterClass
    public static void after() {
        if (runner != null) {
            runner.stop();
        }
    }

    @Test
    public void testWatcherExpiredAfterAllServerDown() throws RuntimeEngineException, TimeoutException, InterruptedException {
        runner.runtime().enforceOrder("E1", () -> {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            try {
                zooKeeper[0] = new ZooKeeper(helper.connectionStr, 4000, watchedEvent -> countDownLatch.countDown());
                countDownLatch.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        runner.runtime().enforceOrder("E2", () -> {
            try {
                zooKeeper[0].create(nodePath, "1".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                Thread.sleep(2000);
                logger.info("create ephemeral node on " + nodePath);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        runner.runtime().enforceOrder("X1", () -> {
            List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
            list.remove(helper.leaderId - 1);
            String leader = "server" + helper.leaderId;
            System.out.println("leader: " + leader);
            String follower = "server" + list.get(0) + ",server" + list.get(1);
            logger.info("follower: " + follower);

            netPart = NetPart.partitions(leader, follower).build();
            runner.runtime().networkPartition(netPart);
        });

        runner.runtime().enforceOrder("E3", () -> {
            try {
                Thread.sleep(5000);
                zooKeeper[0].close();
                Thread.sleep(5000);
                logger.info("zooKeeper[0] session closed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        runner.runtime().enforceOrder("X2", () -> {
            runner.runtime().removeNetworkPartition(netPart);
        });

        runner.runtime().enforceOrder("E4", () -> {
            CountDownLatch countDownLatch2 = new CountDownLatch(1);
           try {
               zooKeeper[1] = new ZooKeeper(runner.runtime().ip("server1") + ":2181",4000, watchedEvent -> countDownLatch2.countDown());
               Stat exists = zooKeeper[1].exists(nodePath, false);
               logger.info("******************** Node have not been deleted from leader: " + exists.toString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        runner.runtime().enforceOrder("E5", () -> {
            CountDownLatch countDownLatch3 = new CountDownLatch(1);
            try {
                zooKeeper[2] = new ZooKeeper(runner.runtime().ip("server2") + ":2181", 4000, watchedEvent -> countDownLatch3.countDown());
                Stat nodeAtFollower = zooKeeper[2].exists(nodePath, false);
                logger.info("Follower had one extra ephemeral node /e1: " + nodeAtFollower.toString());
                zooKeeper[2].create(nodePath, "2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        runner.runtime().waitForRunSequenceCompletion(20);
        logger.info("completed !!!");
    }
}
