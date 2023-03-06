# Redit-Zookeeper-4473

### Details

Title: ***zooInspector create root node fail with path validate***

JIRA link：[https://issues.apache.org/jira/browse/ZOOKEEPER-4473](https://issues.apache.org/jira/browse/ZOOKEEPER-4473)

|         Label         | Value              | Label           | Value               |
|:---------------------:|:--------:          |:---------------:|:--------:           |
|       **Type**        | Bug                | **Priority**    | Major               |
|      **Status**       | RESOLVED           | **Resolution**  | Fixed               |
| **Affects Version/s** | 3.7.0, 3.6.2       | **Fix Version/s** | 3.9.0, 3.8.1      |

### Description

Create root node using zoo inspector will fail with an exception, and what's worse is the UI will be updated, even creation failed.
```
java.lang.IllegalArgumentException: Invalid path string "//test" caused by empty node name specified @1
```

### Testcase

Reproduced version：3.8.0

Steps to reproduce：
1. Start a three-node zookeeper cluster, create a ZooInspectorManagerImpl object and connect to the cluster.
2. Test create zookeeper node operation and create a normal child node.
3. The above exception will be thrown during node creation:
```
09:56:32.583 [main-SendThread(10.2.0.2:2181)] DEBUG org.apache.zookeeper.ClientCnxn - Reading reply session id: 0x300001c7cc70000, packet:: clientPath:null serverPath:null finished:false header:: 1,3  replyHeader:: 1,4294967297,0  request:: '/,F  response:: s{0,0,0,0,0,-1,0,0,0,1,0}
09:56:32.599 [main] ERROR org.apache.zookeeper.inspector - Error occurred creating node: //test
java.lang.IllegalArgumentException: Invalid path string "//test" caused by empty node name specified @1
	at org.apache.zookeeper.common.PathUtils.validatePath(PathUtils.java:91)
  ...
```

### Patch 

Status：Available

Link：[https://github.com/apache/zookeeper/pull/1818/commits/f75cba2b46ecae39c059cec5cd04d993bdf7d567](https://github.com/apache/zookeeper/pull/1818/commits/f75cba2b46ecae39c059cec5cd04d993bdf7d567)

Fix version：3.8.0

Patches fix client program code rather than system deployment packages.
