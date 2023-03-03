# Redit-Cassandra-15297

### Details

Title: ***nodetool can not create snapshot with snapshot name that have special character***

JIRA link：[https://issues.apache.org/jira/browse/CASSANDRA-15297](https://issues.apache.org/jira/browse/CASSANDRA-15297)

|         Label         |                  Value                   |      Label      |     Value      |
|:---------------------:|:----------------------------------------:|:---------------:|:--------------:|
|       **Type**        |                   Bug                    |  **Priority**   |     Normal     |
|      **Status**       |                 RESOLVED                 | **Resolution**  |     Fixed      |
| **Affects Version/s** |                  3.0.0                   | **Fix Version/s** | 4.0.4, 4.1-alpha1, 4.1 |

### Description

We make snapshot through "nodetool snapshot -t snapshotname " , when snapshotname contains special characters like "/", the make snapshot process successfully , but the result
can be different ,when we check the data file directory or use "nodetool listsnapshots".
here is some case :

1. nodetool snapshot -t "p/s"
The listsnapshot resturns snapshot p for all table but actually the snapshot name is "p/s"; also the data directory is like the format : datapath/snapshots/p/s/snapshot-datafile-link

2. nodetool snapshot -t "/"
The listsnapshot resturns "there is not snapshot"; but the make snapshot process return successfully and the data directory is like the format : datapath/snapshots/snapshot-datafile-link

The Attachements are the result under our environment. So for me , we suggest that the snapshot name should not contains special character. just throw exception and told the user not to use special character.

### Testcase

Reproduced version：3.11.6

Steps to reproduce：

1. Create and set snapshots for all keyspaces through nodetool, the address is "p/s".
2. Check the snapshot through "bin/nodetool listsnapshots", and find that the snapshot name is p, and its actual snapshot address is "data_file + /snapshots/p/s".

### Patch 

Status：Available

Link：[https://github.com/apache/cassandra/pull/352/commits/56f6d9851ad3f491316f901e6a24d85506dd7544](https://github.com/apache/cassandra/pull/352/commits/56f6d9851ad3f491316f901e6a24d85506dd7544)

Fix version：3.11.6

Regression testing path：Archive/Cassandra/Cassandra-15297/apache-cassandra-3.11.6-src/fix/
