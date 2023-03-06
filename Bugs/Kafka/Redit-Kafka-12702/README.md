# Redit-Kafka-12702

### Details

Title: ***kafka-configs.sh end with UnsupportedVersionException when describing TLS user with quotas***

JIRA link：[https://issues.apache.org/jira/browse/KAFKA-12702](https://issues.apache.org/jira/browse/KAFKA-12702)

|         Label         | Value |      Label       |    Value     |
|:---------------------:|:-----:|:----------------:|:------------:|
|       **Type**        |  Bug  |   **Priority**   |    Blocker   |
|      **Status**       | RESOLVED|  **Resolution**|  Fixed  |
| **Affects Version/s** | 2.8.0 | **Fix Version/s**  | 2.8.1, 3.0.0 |

### Description

In kraft mode, if listeners and advertised.listeners are not configured with host addresses, the host parameter value of Listener in BrokerRegistrationRequestData will be null. When the broker is started, a null pointer exception will be thrown, causing startup failure.

A feasible solution is to replace the empty host of endPoint in advertisedListeners with InetAddress.getLocalHost.getCanonicalHostName in Broker Server when building networkListeners.

The following is the debug log:

```
[2021-04-21 14:15:20,032] DEBUG (broker-2-to-controller-send-thread org.apache.kafka.clients.NetworkClient 522) [broker-2-to-controller] Sending BROKER_REGISTRATION request with header RequestHeader(apiKey=BROKER_REGIS
TRATION, apiVersion=0, clientId=2, correlationId=6) and timeout 30000 to node 2: BrokerRegistrationRequestData(brokerId=2, clusterId='nCqve6D1TEef3NpQniA0Mg', incarnationId=X8w4_1DFT2yUjOm6asPjIQ, listeners=[Listener(n
ame='PLAINTEXT', host=null, port=9092, securityProtocol=0)], features=[], rack=null)
[2021-04-21 14:15:20,033] ERROR (broker-2-to-controller-send-thread kafka.server.BrokerToControllerRequestThread 76) [broker-2-to-controller-send-thread]: unhandled exception caught in InterBrokerSendThread
java.lang.NullPointerException
at org.apache.kafka.common.message.BrokerRegistrationRequestData$Listener.addSize(BrokerRegistrationRequestData.java:515)
at org.apache.kafka.common.message.BrokerRegistrationRequestData.addSize(BrokerRegistrationRequestData.java:216)
at org.apache.kafka.common.protocol.SendBuilder.buildSend(SendBuilder.java:218)
at org.apache.kafka.common.protocol.SendBuilder.buildRequestSend(SendBuilder.java:187)
at org.apache.kafka.common.requests.AbstractRequest.toSend(AbstractRequest.java:101)
at org.apache.kafka.clients.NetworkClient.doSend(NetworkClient.java:525)
at org.apache.kafka.clients.NetworkClient.doSend(NetworkClient.java:501)
at org.apache.kafka.clients.NetworkClient.send(NetworkClient.java:461)
at kafka.common.InterBrokerSendThread.$anonfun$sendRequests$1(InterBrokerSendThread.scala:104)
at kafka.common.InterBrokerSendThread.$anonfun$sendRequests$1$adapted(InterBrokerSendThread.scala:99)
at kafka.common.InterBrokerSendThread$$Lambda$259/910445654.apply(Unknown Source)
at scala.collection.IterableOnceOps.foreach(IterableOnce.scala:563)
at scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:561)
at scala.collection.AbstractIterable.foreach(Iterable.scala:919)
at kafka.common.InterBrokerSendThread.sendRequests(InterBrokerSendThread.scala:99)
at kafka.common.InterBrokerSendThread.pollOnce(InterBrokerSendThread.scala:73)
at kafka.server.BrokerToControllerRequestThread.doWork(BrokerToControllerChannelManager.scala:368)
at kafka.utils.ShutdownableThread.run(ShutdownableThread.scala:96)
[2021-04-21 14:15:20,034] INFO (broker-2-to-controller-send-thread kafka.server.BrokerToControllerRequestThread 66) [broker-2-to-controller-send-thread]: Stopped
```

### Testcase

Reproduced version：2.13-2.8.0

Steps to reproduce：
1. Start kafka in a three-node cluster using KRaft, omit the host address in the configuration file: 
```
listeners = PLAINTEXT://:9092,CONTROLLER://:19091
inter.broker.listener.name=PLAINTEXT
advertised.listeners=PLAINTEXT://:9092
```
2. The exception will be thrown when the broker is started, causing the node to crash：
```
[2022-12-12 09:31:59,313] ERROR [broker-1-to-controller-send-thread]: unhandled exception caught in InterBrokerSendThread (kafka.server.BrokerToControllerRequestThread)
java.lang.NullPointerException
	at org.apache.kafka.common.message.BrokerRegistrationRequestData$Listener.addSize(BrokerRegistrationRequestData.java:515)
```

### Patch 

Status：Available

Link：[https://github.com/apache/kafka/pull/10586/commits](https://github.com/apache/kafka/pull/10586/commits)

Fix version：2.8.0

Regression testing path：Archive/Kafka/Kafka-12702/kafka-2.8.0-src/fix/
