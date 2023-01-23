import io.redit.ReditRunner;
import io.redit.exceptions.RuntimeEngineException;
import io.redit.helpers.ActivemqHelper;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.*;

public class SampleTest {
    private static final Logger logger = LoggerFactory.getLogger(SampleTest.class);
    protected static ReditRunner runner;
    private static ActivemqHelper helper;
    private static final String TOPIC_NAME = "test-topic";
    private static ActiveMQConnectionFactory connectionFactory;

    @BeforeClass
    public static void before() throws RuntimeEngineException, InterruptedException {
        runner = ReditRunner.run(ReditHelper.getDeployment());
        ReditHelper.startNodes(runner);
        String[] homeDir = {ReditHelper.getRocketmq1HomeDir(), ReditHelper.getRocketmq2HomeDir(), ReditHelper.getRocketmq3HomeDir()};
        helper = new ActivemqHelper(runner, homeDir, logger, ReditHelper.numOfServers);

        helper.startServers();
        Thread.sleep(15000);
        helper.checkServers();
    }

    @AfterClass
    public static void after() {
        if (runner != null) {
            runner.stop();
        }
    }

    @Test
    public void testActiveMQNoLocal() throws Exception {
        runner.runtime().enforceOrder("E1", () -> {
            logger.info("create ActiveMQConnectionFactory ...");
            connectionFactory = new ActiveMQConnectionFactory();
            connectionFactory.setBrokerURL(helper.ACTIVEMQ_URL1);
            connectionFactory.setClientID("test-client");
        });

        runner.runtime().enforceOrder("E2", () -> {
            try {
                Connection connection = connectionFactory.createConnection();
                connection.start();
                createTwoSessions("first time", connection);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        Thread.sleep(5000);

        runner.runtime().enforceOrder("E3", () -> {
            try {
                Connection connection = connectionFactory.createConnection();
                connection.start();
                createTwoSessions("second time", connection);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        runner.runtime().waitForRunSequenceCompletion(20);
        logger.info("completed !!!");
    }

    private static void createTwoSessions(String sessionId, Connection connection) throws JMSException, InterruptedException {
        logger.info("create incomingMessagesSession " + sessionId);
        Session incomingMessagesSession = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Topic topic = incomingMessagesSession.createTopic(TOPIC_NAME);
        TopicSubscriber consumer = incomingMessagesSession.createDurableSubscriber(topic, "test-subscription", null, true);
        consumer.setMessageListener(message -> {
            try {
                System.out.println("incoming message: " + message.getJMSMessageID() + "; body: " + ((TextMessage) message).getText());
                message.acknowledge();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });

        logger.info("create outgoingMessagesSession " + sessionId);
        Session outgoingMessagesSession = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
        Destination destination = outgoingMessagesSession.createTopic(TOPIC_NAME);
        MessageProducer producer = outgoingMessagesSession.createProducer(destination);
        TextMessage textMessage = outgoingMessagesSession.createTextMessage("test-message");
        producer.send(textMessage);
        producer.close();
        System.out.println("message sent:     " + textMessage.getJMSMessageID() + "; body: " + textMessage.getText());
        outgoingMessagesSession.close();

        Thread.sleep(3000);
        consumer.close();
        incomingMessagesSession.close();
        connection.close();
    }
}
