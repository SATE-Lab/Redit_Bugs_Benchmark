# Redit-Cassandra-13669

### Details

Title: ***Error when starting cassandra: Unable to make UUID from 'aa' (SASI index)***

JIRA link：[https://issues.apache.org/jira/browse/CASSANDRA-13669](https://issues.apache.org/jira/browse/CASSANDRA-13669)

|         Label         |                  Value                   |      Label      |     Value      |
|:---------------------:|:----------------------------------------:|:---------------:|:--------------:|
|       **Type**        |                   Bug                    |  **Priority**   |     Urgent     |
|      **Status**       |                 RESOLVED                 | **Resolution**  |     Fixed      |
|   **Since Version**   |                   3.9                    | **Fix Version/s** | 3.11.3, 4.0-alpha1, 4.0 |

### Description

Recently I experienced a problem that prevents me to restart cassandra.
I narrowed it down to SASI Index when added on uuid field.

Steps to reproduce:

1. start cassandra (./bin/cassandra -f)

2. create keyspace, table, index and add data:
```
CREATE KEYSPACE testkeyspace
WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'} 
           AND durable_writes = true;

use testkeyspace ;

CREATE TABLE testtable (
   col1 uuid,
   col2 uuid,
   ts timeuuid,
   col3 uuid,
   PRIMARY KEY((col1, col2), ts) ) with clustering order by (ts desc);

CREATE CUSTOM INDEX col3_testtable_idx ON testtable(col3)
USING 'org.apache.cassandra.index.sasi.SASIIndex'
WITH OPTIONS = {'analyzer_class': 'org.apache.cassandra.index.sasi.analyzer.StandardAnalyzer', 'mode': 'PREFIX'};

INSERT INTO testtable(col1, col2, ts, col3)
VALUES(898e0014-6161-11e7-b9b7-238ea83bd70b,
               898e0014-6161-11e7-b9b7-238ea83bd70b,
               now(), 898e0014-6161-11e7-b9b7-238ea83bd70b);
```

3. restart cassandra

It crashes with an error (sorry it's huge):
```
DEBUG 09:09:20 Writing Memtable-testtable@1005362073(0.075KiB serialized bytes, 1 ops, 0%/0% of on/off-heap limit), flushed range = (min(-9223372036854775808), max(9223372036854775807)]
ERROR 09:09:20 Exception in thread Thread[PerDiskMemtableFlushWriter_0:1,5,main]
org.apache.cassandra.serializers.MarshalException: Unable to make UUID from 'aa'
	at org.apache.cassandra.db.marshal.UUIDType.fromString(UUIDType.java:118) ~[apache-cassandra-3.9.jar:3.9]
	at org.apache.cassandra.index.sasi.analyzer.StandardAnalyzer.hasNext(StandardAnalyzer.java:168) ~[apache-cassandra-3.9.jar:3.9]
    	...
```

### Testcase

Reproduced version：3.9

Steps to reproduce：
1. Create a client connection cluster, create a key space, column cluster, index and insert test data.
2. Inject node crash failure, restart "server1" node.
3. Check the running status of the server1 node and find that it failed to start.
4. Check the logs, exceptions are thrown on startup:

```
ERROR [PerDiskMemtableFlushWriter_0:1] 2023-01-12 09:25:10,089 CassandraDaemon.java:228 - Exception in thread Thread[PerDiskMemtableFlushWriter_0:1,5,main]
org.apache.cassandra.serializers.MarshalException: Unable to make UUID from 'aa'
	at org.apache.cassandra.db.marshal.UUIDType.fromString(UUIDType.java:118) ~[apache-cassandra-3.11.3.jar:3.11.3-SNAPSHOT]
	...
```

### Patch 

Status：Available

Link：[https://github.com/apache/cassandra/commit/ea62d8862c311e3d9b64d622bea0a68d3825aa7d](https://github.com/apache/cassandra/commit/ea62d8862c311e3d9b64d622bea0a68d3825aa7d)

Fix version：3.11.3

Regression testing path：Archive/Cassandra/Cassandra-13669/apache-cassandra-3.11.3-src/fix/
