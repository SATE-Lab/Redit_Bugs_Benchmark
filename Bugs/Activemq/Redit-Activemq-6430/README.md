# Redit-ActiveMQ-6430

### Details
Title: *noLocal=true in durable subscriptions is ignored after reconnect*
JIRA link：[https://issues.apache.org/jira/browse/AMQ-6430](https://issues.apache.org/jira/browse/AMQ-6430)

|         Label         |       Value       |      Label      |        Value        |
|:---------------------:|:-----------------:|:---------------:|:-------------------:|
|       **Type**        |        Bug        |  **Prio rity**  |        Major        |
|      **Status**       |     RESOLVED      | **Resolution**  |        Fixed        |
| **Affects Version/s** |   5.13.4, 5.14.0  | **Affects Version/s**| 5.14.1, 5.15.0 |

### Description

I create a connection to my local ActiveMQ and open two sessions. In the first session I create a durable topic subscriber with noLocal=true. In the second session I send a message to the same topic. Then I close both sessions and the connection. The first time I do this, everything works well, that means I send but do not receive the message. The second time I run the same application I send AND receive the message.

After removing all files and directories in ActiveMQ's data directory, not receiving my own message works again, but only once.

### Testcase

Reproduced version：5.14.0

Steps to reproduce：
1. Create an ActiveMQConnectionFactory object and set parameters.
2. Establish a connection with the cluster and create two sessions for the first time.
3. Establish a connection with the cluster and create two sessions for the secend time.
4. From the log, it is found that only the message is sent in the first time, and the message is sent and accepted in the second time.

### Patch 

Status：Available
Link：[https://github.com/apache/activemq/commit/e0c70b8](https://github.com/apache/activemq/commit/e0c70b8)
Fix version：5.14.0
Regression testing path：Archive/Activemq/Activemq-6430/activemq-parent-5.14.0-src/fix/
