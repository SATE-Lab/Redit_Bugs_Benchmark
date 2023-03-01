# Redit-ActiveMQ-7337

### Details

Title: ***Slow consumer with prefetch 0 fails to re-establish message pull state after failover***

JIRA link：[https://issues.apache.org/jira/browse/AMQ-7337](https://issues.apache.org/jira/browse/AMQ-7337)

|         Label         |       Value       |      Label      |        Value        |
|:---------------------:|:-----------------:|:---------------:|:-------------------:|
|       **Type**        |        Bug        |  **Priority**   |        Major        |
|      **Status**       |       OPEN        | **Resolution**  |     Unresolved      |
| **Affects Version/s** |   5.15.2, 5.15.9  | **Fix Version/s** |       None        |

### Description

Periodically, I have a prefetch 0 consumer that stops receiving messages from the broker when it is idle for an extended period of time before a broker failover occurs. Upon a re-connection, the connection (and consumer) is successfully re-established with the new broker, but the consumer will never receive messages again. There are many WARN lines in the logs. However, none of these correspond with the session for the consumer that is not receiving messages. These all correspond to subscriptions that have been closed:

```
2019-11-05 11:24:14,490 [ActiveMQ Transport: tcp:///127.0.0.1:58742@61616] WARN - Async error occurred: java.lang.IllegalArgumentException: The subscription does not exist: ID:local-58699-1572981850004-8:1:1799:1
Other consumers on this same connection (also configured with prefetch 0) will successfully receive messages.
```

System config:
Master / Slave broker configuration
Shared connection between multiple consumers on multiple queues.
Connection configured with `jms.prefetchPolicy.all=0`
Transacted Consumers receive messages with a timeout of zero (blocking until message is sent)
Consumers are short lived (only receive a single message before closing)
Discovered on activemq client 5.15.2, reproduced on 5.15.9

I created a few test cases which I believe highlight the problem I'm seeing (attached)

For simplicity, the failover is modeled as stopping and starting up a new BrokerService.

Notably, there appears to be a message cache of variable size on the  ConnectionStateTracker that contains MessagePull commands that will be sent to the new broker when a failover happens. 
If a consumer waits for a message for an extended period of time, its MessagePull command will get ejected from this cache if there are enough other MessagePulls from other consumers that fill the cache.
It looks like a MessagePull command is sent every time a receive is called on a Consumer that is configured with prefetch 0, but they are de-duplicated (by consumer id) by the ConnectionStateTracker.
If there are 328 (with the 128k default cache size) consumers created which each issue at least a single receive, the entire cache will have cycled and anything in the cache before will have gotten evicted leaving any other consumers waiting for messages indefinitely.
In these test cases, we see a large number of consumers and a saturated messageCache with MessagePull commands that are no longer relevant because the consumer has since closed. Upon re-connection to a new broker, these MessagePull commands are flushed, and the Broker rejects them with the above error because the session has since been closed. Perhaps these commands can be removed from the cache when the consumer closes. However, this same problem could occur with the same number of "active" consumers.

Seeking to work around this, I tried using a timed receive model (waiting for a second before giving up and trying again), however even the timed receive seems to hang if a failover occurs after the consumer's MessagePull is ejected from the cache as a prefetch 0 consumer seems to rely on the broker to notify it when the timeout happens, but if a failover occurs, the new broker won't be able to notify it of the expiration. However, using a shorter receive timeout reduces the windows of time where this can occur (as enough MessagePulls must be sent to overflow the cache in a small time window). EDIT: I don't actually know if this strategy will work, as the de-duplication mechanism in the ConnectionStateTracker may not actually refresh the position of the MessagePull for this consumer in the messagesCache.

Moving a to re-used consumer seems to avoid this problem in this simple test case (receiving all messages on the same consumer) as there would only be a single additional consumer and not overflow this cache.

Bumping up the cache size seems to defer the problem, allowing for more consumers to be used before a long running consumer might hang.

### Testcase

Reproduced version：5.15.9

Steps to reproduce：
1. Create an ActiveMQConnectionFactory object and connect to the cluster.
2. Start a prefetch 0 consumer that stops receiving messages from brokers when it is idle for a long time before broker failover occurs.
3. Simulated node crashes, and upon reconnection, the connection (and consumer) is successfully re-established with the new broker, but the consumer will never receive messages again. and throws an exception:

```
java.lang.IllegalArgumentException: The subscription does not exist: ID:zmb-virtual-machine-39687-1664182626894-1:1:655:1
```

### Patch 

Status：Not submitted
