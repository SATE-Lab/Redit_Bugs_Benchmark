# Redit-Cassandra-16836

### Details

Title: ***Materialized views incorrect quoting of UDF***

JIRA link：[https://issues.apache.org/jira/browse/CASSANDRA-16836](https://issues.apache.org/jira/browse/CASSANDRA-16836)

|         Label         |                  Value                   |      Label      |     Value      |
|:---------------------:|:----------------------------------------:|:---------------:|:--------------:|
|       **Type**        |                   Bug                    |  **Priority**   |     Normal     |
|      **Status**       |                 RESOLVED                 | **Resolution**  |     Fixed      |
|   **Since Version**   |                  3.11.x                  | **Fix Version/s** | 3.11.12, 4.1-alpha1, 4.1 |

### Description

Creating a MV with a UDF needing quotes will explode on inserts after restart:

```
create keyspace test WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

use test;

CREATE TABLE t (k int PRIMARY KEY, v int);

CREATE FUNCTION "Double" (input int) 

   CALLED ON NULL INPUT 

   RETURNS int 

   LANGUAGE java 

   AS 'return input*2;';

CREATE MATERIALIZED VIEW mv AS SELECT * FROM t 

   WHERE k < test."Double"(2) 

   AND k IS NOT NULL 

   AND v IS NOT NULL 

   PRIMARY KEY (v, k);
 
```

Now restart the node, run an insert and you get an error:

```
INSERT INTO t(k, v) VALUES (3, 1);
ERROR [MutationStage-2] 2021-08-10 09:55:56,662 StorageProxy.java:1551 - Failed to apply mutation locally : 
org.apache.cassandra.exceptions.InvalidRequestException: Unknown function test.double called
	at org.apache.cassandra.cql3.statements.RequestValidations.invalidRequest(RequestValidations.java:217)
	...
WriteFailure: Error from server: code=1500 [Replica(s) failed to execute write] message="Operation failed - received 0 responses and 1 failures: UNKNOWN from localhost/127.0.0.1:7000" info={'consistency': 'ONE', 'required_responses': 1, 'received_responses': 0, 'failures': 1, 'error_code_map': {'127.0.0.1': '0x0000'}}
```

### Testcase

Reproduced version：3.11.6

Steps to reproduce：
1. Create a client connection cluster and create keyspace, table, custom method and MATERIALIZED VIEW in turn.
2. Inject node crash failure, restart "server2" node.
3. Check the running status of the node, it is running normally.
4. Execute the cql statement to insert test data and throw an exception:

```
18:25:23.804 [cluster2-nio-worker-2] DEBUG com.datastax.driver.core.Connection - Connection[/10.2.0.3:9042-3, inFlight=1, closed=false] Keyspace set to test
com.datastax.driver.core.exceptions.WriteFailureException: Cassandra failure during write query at consistency LOCAL_ONE (1 responses were required but only 0 replica responded, 1 failed)
	at com.datastax.driver.core.exceptions.WriteFailureException.copy(WriteFailureException.java:174)
	...
```

### Patch 

Status：Available

Link：[https://github.com/apache/cassandra/pull/1132/commits/bfc87c103d0ad8df4f464381b34556887067fc76](https://github.com/apache/cassandra/pull/1132/commits/bfc87c103d0ad8df4f464381b34556887067fc76)

Fix version：3.11.6

Regression testing path：Archive/Cassandra/Cassandra-16836/apache-cassandra-3.11.6-src/fix/
