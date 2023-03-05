# Redit-Kafka-12866

### Details

Title: ***Kafka requires ZK root access even when using a chroot***

JIRA link：[https://issues.apache.org/jira/browse/KAFKA-12866](https://issues.apache.org/jira/browse/KAFKA-12866)

|         Label         |        Value        |      Label      |         Value          |
|:---------------------:|:-------------------:|:---------------:|:----------------------:|
|       **Type**        |         Bug         |  **Priority**   |         Major          |
|      **Status**       |      RESOLVED       | **Resolution**  |         Fixed          |
| **Affects Version/s** | 2.6.1, 2.8.0, 2.7.1, 2.6.2 | **Fix Version/s** |     3.0.0     |

### Description

When a Zookeeper chroot is configured, users do not expect Kafka to need Zookeeper access outside of that chroot.

Why is this important?
A zookeeper cluster may be shared with other Kafka clusters or even other applications. It is an expected security practice to restrict each cluster/application's access to it's own Zookeeper chroot.

Steps to reproduce
Zookeeper setup
Using the zkCli, create a chroot for Kafka, make it available to Kafka but lock the root znode.

```
[zk: localhost:2181(CONNECTED) 1] create /somechroot
Created /some
[zk: localhost:2181(CONNECTED) 2] setAcl /somechroot world:anyone:cdrwa
[zk: localhost:2181(CONNECTED) 3] addauth digest test:12345
[zk: localhost:2181(CONNECTED) 4] setAcl / digest:test:Mx1uO9GLtm1qaVAQ20Vh9ODgACg=:cdrwa
```

Kafka setup
Configure the chroot in broker.properties:

```
zookeeper.connect=localhost:2181/somechroot
```

Expected behavior
The expected behavior here is that Kafka will use the chroot without issues.

Actual result
Kafka fails to start with a fatal exception:
```
    org.apache.zookeeper.KeeperException$NoAuthException: KeeperErrorCode = NoAuth for /chroot
        at org.apache.zookeeper.KeeperException.create(KeeperException.java:120)
        at org.apache.zookeeper.KeeperException.create(KeeperException.java:54)
        at kafka.zookeeper.AsyncResponse.maybeThrow(ZooKeeperClient.scala:583)
        at kafka.zk.KafkaZkClient.createRecursive(KafkaZkClient.scala:1729)
        at kafka.zk.KafkaZkClient.makeSurePersistentPathExists(KafkaZkClient.scala:1627)
        at kafka.zk.KafkaZkClient$.apply(KafkaZkClient.scala:1957)
        at kafka.zk.ZkClientAclTest.testChrootExistsAndRootIsLocked(ZkClientAclTest.scala:60)
```

### Testcase

Reproduced version：2.8.0

Steps to reproduce：
1. After starting the zk cluster, create a permanent node "/chroot" and set acl access permissions.
2. Add auth information, and set acl access permissions in the root directory.
3. After the configuration of kafka is set to zookeeper.connect, the node path is added, and the kafka cluster starts to crash:
```
org.apache.zookeeper.KeeperException$NoAuthException: KeeperErrorCode = NoAuth for /chroot
	at org.apache.zookeeper.KeeperException.create(KeeperException.java:120)
    ...
```

### Patch 

Status：Available

Link：[https://github.com/apache/kafka/pull/10795/commits/c5e13feea88a84052b177243767baae269ee84f4](https://github.com/apache/kafka/pull/10795/commits/c5e13feea88a84052b177243767baae269ee84f4)

Fix version：3.0.0

Regression testing path：Archive/Kafka/Kafka-12866/kafka-3.0.0-src/fix/

