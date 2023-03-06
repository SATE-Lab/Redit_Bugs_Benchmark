# Redit-zookeeper-2355

### Details

Title: ***Ephemeral node is never deleted if follower fails while reading the proposal packet***

JIRA link：[https://issues.apache.org/jira/browse/ZOOKEEPER-2355](https://issues.apache.org/jira/browse/ZOOKEEPER-2355)

|         Label         |        Value        |      Label      |    Value    |
|:---------------------:|:-------------------:|:---------------:|:-----------:|
|       **Type**        |         Bug         |  **Priority**   |  Critical   |
|      **Status**       |      RESOLVED       | **Resolution**  |   Fixed    |
| **Affects Version/s** | 3.4.8, 3.4.9, 3.4.10, 3.5.1, 3.5.2, 3.5.3 | **Fix Version/s** | 3.4.11, 3.5.4, 3.6.0 |

### Description

ZooKeeper ephemeral node is never deleted if follower fail while reading the proposal packet
The scenario is as follows:

1. Configure three node ZooKeeper cluster, lets say nodes are A, B and C, start all, assume A is leader, B and C are follower
2. Connect to any of the server and create ephemeral node /e1
3. Close the session, ephemeral node /e1 will go for deletion
4. While receiving delete proposal make Follower B to fail with SocketTimeoutException. This we need to do to reproduce the scenario otherwise in production environment it happens because of network fault.
5. Remove the fault, just check that faulted Follower is now connected with quorum
6. Connect to any of the server, create the same ephemeral node /e1, created is success.
7. Close the session, ephemeral node /e1 will go for deletion
8. /e1 is not deleted from the faulted Follower B, It should have been deleted as it was again created with another session
9. /e1 is deleted from Leader A and other Follower C

### Testcase

Reproduced version：3.5.3

Steps to reproduce：
1. Start a three-node zookeeper cluster and elect a leader.
2. Create client zk1 to connect to the zookeeper cluster.
3. Use zk1 to create a temporary node "/e1".
4. Implement a network partition between the leader and any follower.
5. Use close() to delete the zk1 client.
6. Remove the previously imposed network partition.
7. Create client zk2 to connect to any zookeeper server.
8. Call zk2.exists(nodePath, false), and find that nodePath has not been deleted.
9. Create a temporary node of the path "/e1" on zk2, and an exception is thrown: KeeperErrorCode = NodeExists for /e1:
```
11:16:55.781 [main] INFO  i.r.samples.zookeeper4466.SampleTest - ******************** Node have not been deleted from leader: 4294967298,4294967298,1676603801103,1676603801103,0,0,0,216173051906490368,1,0,4294967298

11:16:55.811 [main] INFO  i.r.samples.zookeeper4466.SampleTest - Follower had one extra ephemeral node /e1: 4294967298,4294967298,1676603801103,1676603801103,0,0,0,216173051906490368,1,0,4294967298

11:16:55.817 [main-SendThread(10.2.0.3:2181)] DEBUG org.apache.zookeeper.ClientCnxn - Reading reply sessionid:0x200003f184e0000, packet:: clientPath:null serverPath:null finished:false header:: 2,1  replyHeader:: 2,8589934595,-110  request:: '/e1,#32,v{s{31,s{'world,'anyone}}},1  response::

java.lang.RuntimeException: org.apache.zookeeper.KeeperException$NodeExistsException: KeeperErrorCode = NodeExists for /e1
	at io.redit.samples.zookeeper4466.SampleTest.lambda$testWatcherExpiredAfterAllServerDown$9(SampleTest.java:119)
```

### Patch 

Status：Unavailable

Link：[https://github.com/apache/zookeeper/pull/304/commits/007e2b37f24907c03e4e28547756b91aea4f78d4](https://github.com/apache/zookeeper/pull/304/commits/007e2b37f24907c03e4e28547756b91aea4f78d4)

I read ZOOKEEPER-2355 and tried to reproduce it, but I found that this bug is not fixed in the fixed version. Ephemeral nodes are never deleted if the cluster has a network partition while the zookeeper client is closed. I don't understand how this problem was fixed before. I tried two fixed versions 3.5.4 and 3.6.0, and the above reproduction path can still be triggered stably. The bug no longer appeared after I commented out the network partition related content.

I resubmitted this bug on JIRA: [https://issues.apache.org/jira/browse/ZOOKEEPER-4678](https://issues.apache.org/jira/browse/ZOOKEEPER-4678)
