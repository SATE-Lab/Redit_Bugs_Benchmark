# Redit-zookeeper-3479

### Details

Title: ***Logging false leader election times***

JIRA link：[https://issues.apache.org/jira/browse/ZOOKEEPER-3479](https://issues.apache.org/jira/browse/ZOOKEEPER-3479)

|         Label         |        Value        |      Label      |    Value    |
|:---------------------:|:-------------------:|:---------------:|:-----------:|
|       **Type**        |         Bug         |  **Priority**   |    Minor    |
|      **Status**       |      RESOLVED       | **Resolution**  |    Fixed    |
| **Affects Version/s** |       3.5.5         | **Fix Version/s** |   3.6.0   |

### Description

There seems to be a problem with the logging of leader election times: the logged times are much smaller than the actual time it took for the leader election to complete.

This bug can be easily reproduced by following these steps:

1) Run a ZK cluster of 3 servers

2) Kill the server that is currently the leader

3) The log files of the remaining 2 servers contain false leader election times


In the attached files you can see the log files of the remaining 2 serve. For brevity, I removed the parts before and after the leader election from the log files.

For example, in server1.txt we can see that:
```
2019-07-31 00:57:31,852 [myid:1] - WARN [QuorumPeer[myid=1](plain=/0.0.0.0:2791)(secure=disabled):QuorumPeer@1318] - PeerState set to LOOKING
2019-07-31 00:57:31,853 [myid:1] - INFO [QuorumPeer[myid=1](plain=/0.0.0.0:2791)(secure=disabled):QuorumPeer@1193] - LOOKING
2019-07-31 00:57:31,853 [myid:1] - INFO [QuorumPeer[myid=1](plain=/0.0.0.0:2791)(secure=disabled):FastLeaderElection@885] - New election. My id = 1, proposed zxid=0x100000001
[...]
2019-07-31 00:57:32,272 [myid:1] - INFO [QuorumPeer[myid=1](plain=/0.0.0.0:2791)(secure=disabled):Follower@69] - FOLLOWING - LEADER ELECTION TOOK - 1 MS
```

Leader election supposedly took only 1ms, but in reality it took (32,272 - 31,853) = 419ms!

The reason for this bug seems to be the introduction of this line:

```
start_fle = Time.currentElapsedTime();
```

(seen here https://github.com/apache/zookeeper/blob/master/zookeeper-server/src/main/java/org/apache/zookeeper/server/quorum/QuorumPeer.java#L1402) 

back in this commit https://github.com/apache/zookeeper/commit/5428cd4bc963c2e653a260c458a8a8edf3fa08ef.

### Testcase

Reproduced version：3.5.5

Steps to reproduce：
1. Start the zookeeper cluster of three nodes.
2. After the election is completed, kill the leader node and make it re-election.
3. In the log, the leader election is said to take only 1 millisecond, but in fact it took tens or even hundreds of milliseconds!
```
2022-12-06 09:43:26,145 [myid:1] - INFO  [QuorumPeer[myid=1](plain=/0.0.0.0:2181)(secure=disabled):ZooKeeperServer@166] - Created server with tickTime 2000 minSessionTimeout 4000 maxSessionTimeout 40000 datadir /zookeeper/apache-zookeeper-3.5.5-bin/logs/version-2 snapdir /zookeeper/apache-zookeeper-3.5.5-bin/zkdata/version-2
2022-12-06 09:43:26,145 [myid:1] - INFO  [QuorumPeer[myid=1](plain=/0.0.0.0:2181)(secure=disabled):Follower@69] - FOLLOWING - LEADER ELECTION TOOK - 1 MS
```

### Patch 

Status：Available

Link：[https://github.com/apache/zookeeper/pull/1031/commits/1523385108d2ac14cece23a7f4ed97bb9a6a4416](https://github.com/apache/zookeeper/pull/1031/commits/1523385108d2ac14cece23a7f4ed97bb9a6a4416)

Fix version：3.5.5

Regression testing path：Archive/Zookeeper/Zookeeper-3479/zookeeper-3.5.5-src/fix/
