# Redit-HDFS-16381

### Details

Title: ***Unexpected crashes on the NN cause lease related errors***

JIRA link：[https://issues.apache.org/jira/browse/HDFS-16381](https://issues.apache.org/jira/browse/HDFS-16381)

|         Label         | Value  |      Label      |   Value    |
|:---------------------:|:------:|:---------------:|:----------:|
|       **Type**        |  Bug   |  **Priority**   |   Major    |
|      **Status**       |  OPEN  | **Resolution**  | Unresolved |
| **Affects Version/s** | 3.3.1  | **Fix Version/s** |   None   |

### Description

We have a file /usr/root/myfile in a HDFS cluster with two NNs and three DNs.

1. client requests to truncate the file: bin/hdfs dfs -truncate -w 23 /usr/root/myfile;
2. current active NN crashes before writing nndir/current/edits_inprogress_0000000000000000028
3. client receives the error message:
```
      Failed to TRUNCATE_FILE /usr/root/myfile for DFSClient_NONMAPREDUCE_955729475_1 on * because DFSClient_NONMAPREDUCE_955729475_1 is already the current lease holder.
```
4. we check the content of the file bin/hdfs dfs -cat /usr/root/myfile, it has been truncated.
5. client request to append to the file /usr/root/myfile, the append operation fails due to:
```
     org.apache.hadoop.ipc.RemoteException(org.apache.hadoop.hdfs.protocol.AlreadyBeingCreatedException): Failed to APPEND_FILE /usr/root/myfile for DFSClient_NONMAPREDUCE_738467545_1 on * because this file lease is currently owned by DFSClient_NONMAPREDUCE_955729475_1 on *
```

### Testcase

Reproduced version：3.3.1

Steps to reproduce：
1. Create a test file /test/myFile.txt in hdfs, execute "AppendTestUtil.write(outputStream, 0, BLOCK_SIZE / 2)".
2. Write half of the blocks to simulate a node crash.
3. Perform outputStream.hflush() and Truncate the test file and throw an exception:
```
org.apache.hadoop.ipc.RemoteException(org.apache.hadoop.hdfs.protocol.AlreadyBeingCreatedException): Failed to TRUNCATE_FILE /test/myFile.txt for DFSClient_NONMAPREDUCE_1344905867_1 on 10.2.0.1 because DFSClient_NONMAPREDUCE_1344905867_1 is already the current lease holder.
	at org.apache.hadoop.hdfs.server.namenode.FSNamesystem.recoverLeaseInternal(FSNamesystem.java:2789)
    ...
```
4. Then create an inputStream, perform inputStream.readUTF(), and finally execute "dfs.append(path, BLOCK_SIZE / 2, null)" to append the file, throwing an exception:
```
org.apache.hadoop.ipc.RemoteException(org.apache.hadoop.hdfs.protocol.AlreadyBeingCreatedException): Failed to APPEND_FILE /test/myFile.txt for DFSClient_NONMAPREDUCE_-1683934480_1 on 10.2.0.1 because DFSClient_NONMAPREDUCE_-1683934480_1 is already the current lease holder.
	at org.apache.hadoop.hdfs.server.namenode.FSNamesystem.recoverLeaseInternal(FSNamesystem.java:2789)
    ...
```

### Patch 

Status：Not submitted
