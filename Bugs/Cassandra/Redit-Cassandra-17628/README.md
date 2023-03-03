# Redit-Cassandra-17628

### Details

Title: ***CQL writetime and ttl functions should be forbidden for multicell columns***

JIRA link：[https://issues.apache.org/jira/browse/CASSANDRA-17628](https://issues.apache.org/jira/browse/CASSANDRA-17628)

|         Label         |                  Value                   |      Label      |     Value      |
|:---------------------:|:----------------------------------------:|:---------------:|:--------------:|
|       **Type**        |                   Bug                    |  **Priority**   |    Normal      |
|      **Status**       |                 RESOLVED                 | **Resolution**  |     Fixed      |
| **Affects Version/s** |                  None                    | **Fix Version/s** |  3.0.28, 3.11.14, 4.0.5, 4.1-alpha1, 4.1, 4.2 |

### Description

CQL writetime and ttl functions are currently forbidden for collections, frozen or not. Also, they are always allowed for UDTs, frozen or not:

```
CREATE TYPE udt (a int, b int);
CREATE TABLE t (k int PRIMARY KEY, s set<int>, fs frozen<set<int>>, t udt, ft frozen<udt>);

SELECT writetime(s) FROM t; -- fails
SELECT writetime(st) FROM t; -- fails
SELECT writetime(t) FROM t; -- allowed
SELECT writetime(ft) FROM t; -- allowed
```

This is done by checking in Selectable.WritetimeOrTTL#newSelectorFactory whether the column is a collection or not. However, I think that what we should check is whether the column is multi-cell. That way the function would work with frozen collections and UDTs, and it would reject unfrozen collections and UDTs:

```
SELECT writetime(s) FROM t; -- fails
SELECT writetime(st) FROM t; -- allowed
SELECT writetime(t) FROM t; -- fails
SELECT writetime(ft) FROM t; -- allowed
```

### Testcase

Reproduced version：3.11.6

Steps to reproduce：
1. Create a client connection cluster, create a keyspace, customize the data type UDT and create a column family containing that type.
2. Tests whether the writetime and ttl functions of aggregates and UDTs are currently disabled.

### Patch 

Status：Available

Link：[https://github.com/apache/cassandra/pull/1690/commits/aaabc0991f24652e534e4dde7440fac94ee9e419](https://github.com/apache/cassandra/pull/1690/commits/aaabc0991f24652e534e4dde7440fac94ee9e419)

Fix version：3.11.6

Regression testing path：Archive/Cassandra/Cassandra-17628/apache-cassandra-3.11.6-src/fix/
