package io.redit.samples.rocketmq257;

import io.redit.ReditRunner;
import io.redit.exceptions.RuntimeEngineException;
import io.redit.execution.CommandResults;
import io.redit.helpers.RocketmqHelper;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
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
    private static RocketmqHelper helper;
    private DefaultMQProducer producer;

    @BeforeClass
    public static void before() throws RuntimeEngineException, IOException, InterruptedException {
        runner = ReditRunner.run(ReditHelper.getDeployment());
        ReditHelper.startNodes(runner);
        helper = new RocketmqHelper(runner, ReditHelper.getRocketmqHomeDir(), logger, ReditHelper.getFileRW(), ReditHelper.numOfServers);
        helper.addRocketPropFile();
        helper.givePermission();

        helper.startServers();
        Thread.sleep(3000);
        helper.startBroker(1, "a");
        Thread.sleep(3000);
        helper.startBroker(2, "a-s");
        Thread.sleep(3000);
        helper.startBroker(2, "b");
        Thread.sleep(3000);
        helper.startBroker(1, "b-s");
        Thread.sleep(3000);
        helper.checkStatus(1);
    }

    @AfterClass
    public static void after() {
        if (runner != null) {
            runner.stop();
        }
    }

    @Test
    public void sampleTest() throws RuntimeEngineException, TimeoutException {
        runner.runtime().enforceOrder("E1", () -> {
            logger.info("startProducer !!!");
            //????????????
            producer = new DefaultMQProducer("producer_group");
            //?????????????????????NameServer????????????broker???????????????????????????????????????????????????Redis????????????
//            producer.setNamesrvAddr(helper.namesrvAddr);
            //??????
            try {
                producer.start();
            } catch (MQClientException e) {
                throw new RuntimeException(e);
            }
            logger.info("producer start successful !!!");
        });

        runner.runtime().enforceOrder("E2", () -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    Message msg = new Message("test_topic", "TagA", "6666", ("RocketMQ Test message " + i).getBytes());
                    //SendResult??????????????????????????????????????????????????????id?????????????????????????????????????????????????????????????????????
                    SendResult sendResult = producer.send(msg);
                    System.out.println("???" + i + "???send??????: " + sendResult);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            producer.shutdown();
        });

        runner.runtime().waitForRunSequenceCompletion(20);
        logger.info("completed !!!");
    }
}
