# Redit-zookeeper-4508

### Details

Title: ***ZooKeeper client run to endless loop in ClientCnxn.SendThread.run if all server down***

JIRA link：[https://issues.apache.org/jira/browse/ZOOKEEPER-4508](https://issues.apache.org/jira/browse/ZOOKEEPER-4508)

|         Label         |        Value        |      Label      |    Value    |
|:---------------------:|:-------------------:|:---------------:|:-----------:|
|       **Type**        |         Bug         |  **Priority**   |    Major    |
|      **Status**       |   PATCH AVAILABLE   | **Resolution**  | Unresolved  |
| **Affects Version/s** | 3.6.3, 3.7.0, 3.8.0 | **Fix Version/s** |   None    |

### Description

The observable behavior is that client will not get expired event from watcher. The cause if twofold:
1. `updateLastSendAndHeard` is called in reconnection so the session timeout don't decrease.
2. There is not break out from `ClientCnxn.SendThread.run` after session timeout.

### Testcase

Reproduced version：4.0.0-incubating

Steps to reproduce：
1. Start zookeeper in a three-node cluster. 
2. Create a `CompletableFuture` object which name is `expired` and set it complete when `event.getState()` equals to `Event.KeeperState.Expired`.
3. Kill all zookeeper nodes in the cluster and call `expired.join()`.
4. ZooKeeper client will run to endless loop in `ClientCnxn.SendThread.run`:
```
11:15:20.246 [main-SendThread(10.2.0.4:2181)] DEBUG o.a.zookeeper.ClientCnxnSocketNIO - Ignoring exception during shutdown input
java.net.SocketException: Socket is not connected
	at sun.nio.ch.Net.translateToSocketException(Net.java:126)
	...
Caused by: java.nio.channels.NotYetConnectedException: null
	at sun.nio.ch.SocketChannelImpl.shutdownInput(SocketChannelImpl.java:781)
	at sun.nio.ch.SocketAdaptor.shutdownInput(SocketAdaptor.java:415)
	... 4 common frames omitted
11:15:20.247 [main-SendThread(10.2.0.4:2181)] DEBUG o.a.zookeeper.ClientCnxnSocketNIO - Ignoring exception during shutdown output
java.net.SocketException: Socket is not connected
	at sun.nio.ch.Net.translateToSocketException(Net.java:126)
	...
Caused by: java.nio.channels.NotYetConnectedException: null
	at sun.nio.ch.SocketChannelImpl.shutdownOutput(SocketChannelImpl.java:798)
	at sun.nio.ch.SocketAdaptor.shutdownOutput(SocketAdaptor.java:423)
	... 4 common frames omitted
```

### Patch 

Status：Someone submitted but not resolved

Link：[https://github.com/apache/zookeeper/pull/1847/commits/905d56a53fc8b900ba0c3bc2baf395390a4db328](https://github.com/apache/zookeeper/pull/1847/commits/905d56a53fc8b900ba0c3bc2baf395390a4db328)


