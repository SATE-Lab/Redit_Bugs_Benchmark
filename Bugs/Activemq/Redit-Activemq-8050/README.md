# Redit-ActiveMQ-8050

### Details

Title: ***XAException when failing over in the middle of a transaction***

JIRA link：[https://issues.apache.org/jira/browse/AMQ-8050](https://issues.apache.org/jira/browse/AMQ-8050)

|         Label         |       Value       |      Label      |        Value        |
|:---------------------:|:-----------------:|:---------------:|:-------------------:|
|       **Type**        |        Bug        |  **Priority**   |        Major        |
|      **Status**       |       OPEN        | **Resolution**  |     Unresolved      |
| **Affects Version/s** | 3.6.3, 3.7, 3.6.4 | **Fix Version/s** |       None        |

### Description

We have been plagued in production by growing disk usage in KahaDB on our ActiveMQs. We have found that this is caused by hanging transactions, and the only solution so far has been to restart the broker. The hanging transactions happen when we have the occasional network glitch. The networking is out of our control, and not something we can fix.

However, we have found a workaround. Our clients are MDBs in Wildfly. If we disable failover for these, and instead let Wildfly handle creating new connections we don't see the issue.

I have been able to reproduce the error in a unit test. When there is a connection disturbance in the middle of a transaction (on the consumer end) and the client fails over to another broker in the network; it tries to commit the transaction on the new broker.
This fails with

`Transaction 'XID:[...]' has not been started. xaErrorCode:-4`

and the transaction ends up in a weird state on the broker.

We are not using any replicated persistence adapters, just local kahaDB for each broker in the network.

I'm not sure if the error is actually in the client, that can't handle failover during a transaction, or in the broker that doesn't distribute the transaction properly to the other brokers in the network.

I'm also very open to the possibility that this is simply a configuration error on our end, but if so, I have no idea what.

I'm adding the unit test where I have reproduced it. I happily admit that I don't know much about how transactions actually behave in reality, so I might have misconfigured them here, but we see the exact same behaviour in production code where transactions are managed by Wildfly.

### Testcase

Reproduced version：5.15.9

Steps to reproduce：
1. Create an ActiveMQConnectionFactory object and set parameters.
2. Create a connection for the producer to send messages.
3. Create a connection for the consumer to receive messages.
4. When there is a connection disturbance in the middle of a transaction (on the consumer end) and the client fails over to another broker in the network. 
5. It tries to commit the transaction on the new broker, but throws an exception：

```
javax.jms.JMSException: Transaction 'XID:[86,globalId=001ffffff83645c9e,branchId=001ffffff83645c9e]' has not been started. xaErrorCode:-4
    at org.apache.activemq.util.JMSExceptionSupport.create(JMSExceptionSupport.java:54)
    ...
Caused by: javax.transaction.xa.XAException: Transaction 'XID:[86,globalId=001ffffff83645c9e,branchId=001ffffff83645c9e]' has not been started. xaErrorCode:-4
    at org.apache.activemq.transaction.Transaction.newXAException(Transaction.java:213)
    ...
```

### Patch 

Status：Not submitted
