# Redit-HDFS-14987

### Details

Title: ***EC: EC file blockId location info displaying as "null" with hdfs fsck -blockId command***

JIRA link：[https://issues.apache.org/jira/browse/HDFS-14987](https://issues.apache.org/jira/browse/HDFS-14987)

|         Label         |  Value   |      Label      |    Value    |
|:---------------------:|:--------:|:---------------:|:-----------:|
|       **Type**        |   Bug    |  **Priority**   |    Major    |
|      **Status**       | RESOLVED | **Resolution**  |  Duplicate  |
| **Affects Version/s** |  3.1.2   | **Fix Version/s** |   None    |

### Description

EC file blockId location info displaying as "null" with hdfs fsck -blockId command

Check the blockId information of an EC enabled file with "hdfs fsck -blockId"  Check the blockId information of an EC enabled file with "hdfs fsck -blockId"    blockId location related info will display as null,which needs to be rectified.    
Check the attachment "EC_file_block_info"

=======================================================
![img.png](https://issues.apache.org/jira/secure/attachment/12985740/12985740_image-2019-11-13-18-36-29-063.png)

Actual Output :-     null   
Expected output :- It should display the blockId location related info as (nodes, racks) of the block  as specified in the usage info of fsck -blockId option.                 [like : Block replica on datanode/rack: BLR10000xx038/default-rack is HEALTHY]

### Testcase

Reproduced version：3.1.2

Steps to reproduce：
1. Create two test folders in hdfs, and set their erasure coding policies to XOR-2-1-1024k and Replicate respectively.
2. Pass in a txt file in each of the two files.
3. Obtain the blockId of the file storage.
4. Through /bin/hdfs fsck checks the block information separately, and the results are as follows:

```
$ /hadoop/hadoop-3.1.2/bin/hdfs fsck /test_ec/aa.txt -blockId blk_-9223372036854775792

Block Id: blk_-9223372036854775792
Block belongs to: /test_ec/aa.txt
No. of Expected Replica: 2
No. of live Replica: 2
No. of excess Replica: 0
No. of stale Replica: 2
No. of decommissioned Replica: 0
No. of decommissioning Replica: 0
No. of corrupted Replica: 0
null

Fsck on blockId 'blk_-9223372036854775792


$ /hadoop/hadoop-3.1.2/bin/hdfs fsck /test_replica/aa.txt -blockId blk_1073741825

Block Id: blk_1073741825
Block belongs to: /test_replica/aa.txt
No. of Expected Replica: 3
No. of live Replica: 3
No. of excess Replica: 0
No. of stale Replica: 3
No. of decommissioned Replica: 0
No. of decommissioning Replica: 0
No. of corrupted Replica: 0
Block replica on datanode/rack: dn3/default-rack is HEALTHY
Block replica on datanode/rack: dn2/default-rack is HEALTHY
Block replica on datanode/rack: dn1/default-rack is HEALTHY
```

### Patch 

Status：Available

Link：[https://issues.apache.org/jira/secure/attachment/12958270/HDFS-14266-02.patch](https://issues.apache.org/jira/secure/attachment/12958270/HDFS-14266-02.patch)

Fix version：3.1.2

Regression testing path：Archive/Hadoop/HDFS-14987/hadoop-3.1.2-src/fix/

