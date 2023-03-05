# Redit-HDFS-13998

### Details

Title: ***ECAdmin NPE with -setPolicy -replicate***

JIRA link：[https://issues.apache.org/jira/browse/HDFS-13998](https://issues.apache.org/jira/browse/HDFS-13998)

|         Label         |     Value     |      Label      |       Value        |
|:---------------------:|:-------------:|:---------------:|:------------------:|
|       **Type**        |      Bug      |  **Priority**   |       Major        |
|      **Status**       |   RESOLVED    | **Resolution**  |     Abandoned      |
| **Affects Version/s** | 3.2.0, 3.1.2  | **Fix Version/s** |       None       |

### Description

[HDFS-13732](https://issues.apache.org/jira/browse/HDFS-13732) tried to improve the output of the console tool. But we missed the fact that for replication, getErasureCodingPolicy would return null.


### Testcase

Reproduced version：3.1.2

Two testcases：
**Note:** There are many types of Erasure Coding Policy in hdfs, the default is replicate.

1. Start an hdfs cluster, create two test folders in hdfs, and set their erasure coding policies to RS-6-3-1024k and replicate respectively. Obtain its erasure code through DistributedFileSystem.getErasureCodingPolicy. It turns out that the file set to the RS-6-3-1024k policy returns correct information, and the file set to the replicate policy returns null.

2. Start a hdfs cluster, create a test folder in hdfs, and set the erasure code policy to RS-6-3-1024k. Create subfolders in the folder, set the erasure coding policy of the parent folder to replicate. Checking the erasure code policy at this time, it is found that the parent folder is null and the subfolder is RS-6-3-1024k.

### Patch 

Status：Not submitted
