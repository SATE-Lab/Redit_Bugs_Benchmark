# Redit-Rocket-266

### Details

Title: ***Can’t start consumer with a small “consumerThreadMax” number***

JIRA link：[https://issues.apache.org/jira/browse/ROCKETMQ-266](https://issues.apache.org/jira/browse/ROCKETMQ-266)

|         Label         |    Value     | Label           |       Value        |
|:---------------------:|:------------:|:---------------:|:------------------:|
|       **Type**        |     Bug      | **Priority**    |       Major        |
|      **Status**       |    CLOSED    | **Resolution**  |       Fixed        |
| **Affects Version/s** | 4.1.0-incubating | **Fix Version/s** |   4.2.0      |

### Description

When the client set the consumerThreadMax to a value less than the default value(20),
we get the “consumeThreadMin Out of range [1, 1000] “ Exception, which is hard to understand.

### Testcase

Reproduced version：4.1.0-incubating

Steps to reproduce：
1. Create a DefaultMQPushConsumer object, set consumer.setConsumeThreadMax(10).
2. The consumer registers the message listener event and starts consumers to consume data. Throw an exception:
```
org.apache.rocketmq.client.exception.MQClientException: consumeThreadMin Out of range [1, 1000]
See http://rocketmq.apache.org/docs/faq/ for further details.
	at org.apache.rocketmq.client.impl.consumer.DefaultMQPushConsumerImpl.checkConfig(DefaultMQPushConsumerImpl.java:705)
	...
```

### Patch 

Status：Available

Link：[https://github.com/apache/rocketmq/pull/147/commits](https://github.com/apache/rocketmq/pull/147/commits)

Fix version：4.1.0-incubating

Regression testing path：Archive/Rocketmq/Rocketmq-266/rocketmq-all-4.1.0-incubating-src/fix/
