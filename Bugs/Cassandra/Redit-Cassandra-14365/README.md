# Redit-Cassandra-14365

### Details

Title: ***Commit log replay failure for static columns with collections in clustering keys***

JIRA link：[https://issues.apache.org/jira/browse/CASSANDRA-14365](https://issues.apache.org/jira/browse/CASSANDRA-14365)

|         Label         |                  Value                   |      Label      |     Value      |
|:---------------------:|:----------------------------------------:|:---------------:|:--------------:|
|       **Type**        |                   Bug                    |  **Priority**   |     Normal     |
|      **Status**       |                 RESOLVED                 | **Resolution**  |     Fixed      |
|   **Since Version**   |                  2.1.0                   | **Fix Version/s** | 2.2.17, 3.0.21, 3.11.7, 4.0-alpha4, 4.0 |

### Description

In the old storage engine, static cells with a collection as part of the clustering key fail to validate because a 0 byte collection (like in the cell name of a static cell) isn't valid.

To reproduce:

1. 
```
CREATE TABLE test.x (
    id int,
    id2 frozen<map<text, text>>,
    st int static,
    PRIMARY KEY (id, id2)
);

INSERT INTO test.x (id, st) VALUES (1, 2);
```

2. Kill the cassandra process

3. Restart cassandra to replay the commitlog

Outcome:
```
ERROR [main] 2018-04-05 04:58:23,741 JVMStabilityInspector.java:99 - Exiting due to error while processing commit log during initialization.
org.apache.cassandra.db.commitlog.CommitLogReplayer$CommitLogReplayException: Unexpected error deserializing mutation; saved to /tmp/mutation3825739904516830950dat.  This may be caused by replaying a mutation against a table with the same name but incompatible schema.  Exception follows: org.apache.cassandra.serializers.MarshalException: Not enough bytes to read a set
        at org.apache.cassandra.db.commitlog.CommitLogReplayer.handleReplayError(CommitLogReplayer.java:638) [main/:na]
        ...
```

I haven't investigated if there are other more subtle issues caused by these cells failing to validate other places in the code, but I believe the fix for this is to check for 0 byte length collections and accept them as valid as we do with other types.

I haven't had a chance for any extensive testing but this naive patch seems to have the desired affect.

### Testcase

Reproduced version：2.2.16

Steps to reproduce：
1. Create a client connection cluster, create a key space, column cluster and insert test data.
2. Inject node crash failure, restart "server1" node.
3. Check the running status of the server1 node and find that it failed to start.
4. Check the logs, exceptions are thrown on startup:

```
INFO  [main] 2023-01-04 10:19:04,939 CommitLog.java:149 - Replaying /opt/cassandra/commitlog_directory/CommitLog-5-1672827512097.log, /opt/cassandra/commitlog_directory/CommitLog-5-1672827512098.log
ERROR [main] 2023-01-04 10:19:04,978 JVMStabilityInspector.java:99 - Exiting due to error while processing commit log during initialization.
org.apache.cassandra.db.commitlog.CommitLogReplayer$CommitLogReplayException: Unexpected error deserializing mutation; saved to /tmp/mutation5509535472276335289dat.  This may be caused by replaying a mutation against a table with the same name but incompatible schema.  Exception follows: org.apache.cassandra.serializers.MarshalException: Not enough bytes to read a set
	at org.apache.cassandra.db.commitlog.CommitLogReplayer.handleReplayError(CommitLogReplayer.java:638) [apache-cassandra-2.2.16.jar:2.2.16]
    ...
```

### Patch 

Status：Available

Link：[https://github.com/apache/cassandra/commit/ae326eed2aa8f9c761fc7a0a872ce8172fde2f0f](https://github.com/apache/cassandra/commit/ae326eed2aa8f9c761fc7a0a872ce8172fde2f0f)

Fix version：2.2.16

Regression testing path：Archive/Cassandra/Cassandra-14365/apache-cassandra-2.2.16-src/fix/
