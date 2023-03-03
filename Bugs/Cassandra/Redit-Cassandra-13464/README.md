# Redit-Cassandra-13464

### Details

Title: ***Failed to create Materialized view with a specific token range***

JIRA link：[https://issues.apache.org/jira/browse/CASSANDRA-13464](https://issues.apache.org/jira/browse/CASSANDRA-13464)

|         Label         |                  Value                   |      Label      |     Value      |
|:---------------------:|:----------------------------------------:|:---------------:|:--------------:|
|       **Type**        |                   Bug                    |  **Priority**   |      Low       |
|      **Status**       |                 RESOLVED                 | **Resolution**  |     Fixed      |
| **Affects Version/s** |                  3.0.0                   | **Fix Version/s** | 3.0.25, 3.11.11, 4.0.1 |

### Description

Failed to create Materialized view with a specific token range.
Example :
```
$ ccm create "MaterializedView" -v 3.0.13
$ ccm populate  -n 3
$ ccm start
$ ccm status
Cluster: 'MaterializedView'
---------------------------
node1: UP
node3: UP
node2: UP
$ccm node1 cqlsh
Connected to MaterializedView at 127.0.0.1:9042.
[cqlsh 5.0.1 | Cassandra 3.0.13 | CQL spec 3.4.0 | Native protocol v4]
Use HELP for help.
cqlsh> CREATE KEYSPACE test WITH replication = {'class':'SimpleStrategy', 'replication_factor':3};
cqlsh> CREATE TABLE test.test ( id text PRIMARY KEY , value1 text , value2 text, value3 text);

$ccm node1 ring test 
Datacenter: datacenter1
==========
Address    Rack        Status State   Load            Owns                Token
                                                                          3074457345618258602
127.0.0.1  rack1       Up     Normal  64.86 KB        100.00%             -9223372036854775808
127.0.0.2  rack1       Up     Normal  86.49 KB        100.00%             -3074457345618258603
127.0.0.3  rack1       Up     Normal  89.04 KB        100.00%             3074457345618258602

$ ccm node1 cqlsh
cqlsh> INSERT INTO test.test (id, value1 , value2, value3 ) VALUES ('aaa', 'aaa', 'aaa' ,'aaa');
cqlsh> INSERT INTO test.test (id, value1 , value2, value3 ) VALUES ('bbb', 'bbb', 'bbb' ,'bbb');
cqlsh> SELECT token(id),id,value1 FROM test.test;

 system.token(id)     | id  | value1
----------------------+-----+--------
 -4737872923231490581 | aaa |    aaa
 -3071845237020185195 | bbb |    bbb

(2 rows)

cqlsh> CREATE MATERIALIZED VIEW test.test_view AS SELECT value1, id FROM test.test WHERE id IS NOT NULL AND value1 IS NOT NULL AND TOKEN(id) > -9223372036854775808 AND TOKEN(id) < -3074457345618258603 PRIMARY KEY(value1, id) WITH CLUSTERING ORDER BY (id ASC);
ServerError: java.lang.ClassCastException: org.apache.cassandra.cql3.TokenRelation cannot be cast to org.apache.cassandra.cql3.SingleColumnRelation
```

Stacktrace :
```
INFO  [MigrationStage:1] 2017-04-19 18:32:48,131 ColumnFamilyStore.java:389 - Initializing test.test
WARN  [SharedPool-Worker-1] 2017-04-19 18:44:07,263 FBUtilities.java:337 - Trigger directory doesn't exist, please create it and try again.
ERROR [SharedPool-Worker-1] 2017-04-19 18:46:10,072 QueryMessage.java:128 - Unexpected error during query
java.lang.ClassCastException: org.apache.cassandra.cql3.TokenRelation cannot be cast to org.apache.cassandra.cql3.SingleColumnRelation
	at org.apache.cassandra.db.view.View.relationsToWhereClause(View.java:275) ~[apache-cassandra-3.0.13.jar:3.0.13]
	...
ERROR [SharedPool-Worker-1] 2017-04-19 18:46:10,073 ErrorMessage.java:349 - Unexpected exception during request
java.lang.ClassCastException: org.apache.cassandra.cql3.TokenRelation cannot be cast to org.apache.cassandra.cql3.SingleColumnRelation
	at org.apache.cassandra.db.view.View.relationsToWhereClause(View.java:275) ~[apache-cassandra-3.0.13.jar:3.0.13]
	...
INFO  [IndexSummaryManager:1] 2017-04-19 19:20:43,246 IndexSummaryRedistribution.java:74 - Redistributing index summaries
```

### Testcase

Reproduced version：3.11.6

Steps to reproduce：
1. Create a client to connect to the cluster and get the session object.
2. Create key space, column family and insert test data, and query data according to token.
3. Create Materialized view with a specific token range, throws an exception:

```
INFO  [MigrationStage:1] 2022-11-14 08:40:14,106 ColumnFamilyStore.java:427 - Initializing test.test
ERROR [Native-Transport-Requests-1] 2022-11-14 08:40:17,054 QueryMessage.java:129 - Unexpected error during query
java.lang.ClassCastException: org.apache.cassandra.cql3.TokenRelation cannot be cast to org.apache.cassandra.cql3.SingleColumnRelation
	at org.apache.cassandra.db.view.View.relationsToWhereClause(View.java:262) ~[apache-cassandra-3.11.6.jar:3.11.6]
	...
ERROR [Native-Transport-Requests-1] 2022-11-14 08:40:17,055 ErrorMessage.java:384 - Unexpected exception during request
java.lang.ClassCastException: org.apache.cassandra.cql3.TokenRelation cannot be cast to org.apache.cassandra.cql3.SingleColumnRelation
	at org.apache.cassandra.db.view.View.relationsToWhereClause(View.java:262) ~[apache-cassandra-3.11.6.jar:3.11.6]
	...
```

### Patch 

Status：Available

Link：[https://github.com/apache/cassandra/commit/44604b7316fcbfd7d0d7425e75cd7ebe267e3247](https://github.com/apache/cassandra/commit/44604b7316fcbfd7d0d7425e75cd7ebe267e3247)

Fix version：3.11.6

Regression testing path：Archive/Cassandra/Cassandra-13464/apache-cassandra-3.11.6-src/fix/
