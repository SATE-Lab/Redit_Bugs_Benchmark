# Redit-HBASE-23682

### Details

Title: ***Fix NPE when disable DeadServerMetricRegionChore***

JIRA link：[https://issues.apache.org/jira/browse/HBASE-23682](https://issues.apache.org/jira/browse/HBASE-23682)

|         Label         |        Value        |      Label      |         Value          |
|:---------------------:|:-------------------:|:---------------:|:----------------------:|
|       **Type**        |         Bug         |  **Priority**   |         Major          |
|      **Status**       |      RESOLVED       | **Resolution**  |         Fixed          |
| **Affects Version/s** | 3.0.0-alpha-1, 2.3.0, 2.2.3 | **Fix Version/s** | 3.0.0-alpha-1, 2.3.0 |

### Description

set hbase.assignment.dead.region.metric.chore.interval.msec = -1
```
2020-01-13 10:35:46,247 ERROR [master/10.89.25.45:16000:becomeActiveMaster] master.HMaster: Failed to become active master
java.lang.NullPointerException
    at org.apache.hadoop.hbase.procedure2.ProcedureExecutor.addChore(ProcedureExecutor.java:736)
    at org.apache.hadoop.hbase.master.assignment.AssignmentManager.joinCluster(AssignmentManager.java:1381)
    at org.apache.hadoop.hbase.master.HMaster.finishActiveMasterInitialization(HMaster.java:1101)
    at org.apache.hadoop.hbase.master.HMaster.startActiveMasterManager(HMaster.java:2223)
    at org.apache.hadoop.hbase.master.HMaster.lambda$run$0(HMaster.java:605)
    at java.lang.Thread.run(Thread.java:748)
```

### Testcase

Reproduced version：2.2.2

Steps to reproduce：
1. Configure in hbase-site.xml:
```
  <property>
    <name>hbase.assignment.dead.region.metric.chore.interval.msec</name>
    <value>-1</value>
  </property>
```
2. Start the hdfs cluster, the zookeeper cluster and the hbase cluster in turn, and throw the above exception when the master starts:
```
2022-12-23 04:39:15,047 INFO  [master/server1:16000:becomeActiveMaster] procedure2.TimeoutExecutorThread: ADDED pid=-1, state=WAITING_TIMEOUT; org.apache.hadoop.hbase.master.assignment.AssignmentManager$RegionInTransitionChore; timeout=60000, timestamp=1671770415047
2022-12-23 04:39:15,048 ERROR [master/server1:16000:becomeActiveMaster] master.HMaster: Failed to become active master
java.lang.NullPointerException
	at org.apache.hadoop.hbase.procedure2.ProcedureExecutor.addChore(ProcedureExecutor.java:722)
	at org.apache.hadoop.hbase.master.assignment.AssignmentManager.joinCluster(AssignmentManager.java:1359)
	at org.apache.hadoop.hbase.master.HMaster.finishActiveMasterInitialization(HMaster.java:1065)
	at org.apache.hadoop.hbase.master.HMaster.startActiveMasterManager(HMaster.java:2112)
	at org.apache.hadoop.hbase.master.HMaster.lambda$run$0(HMaster.java:580)
	at java.lang.Thread.run(Thread.java:748)
2022-12-23 04:39:15,048 ERROR [master/server1:16000:becomeActiveMaster] master.HMaster: Master server abort: loaded coprocessors are: []
2022-12-23 04:39:15,048 ERROR [master/server1:16000:becomeActiveMaster] master.HMaster: ***** ABORTING master server1,16000,1671770343246: Unhandled exception. Starting shutdown. *****
java.lang.NullPointerException
	at org.apache.hadoop.hbase.procedure2.ProcedureExecutor.addChore(ProcedureExecutor.java:722)
	at org.apache.hadoop.hbase.master.assignment.AssignmentManager.joinCluster(AssignmentManager.java:1359)
	at org.apache.hadoop.hbase.master.HMaster.finishActiveMasterInitialization(HMaster.java:1065)
	at org.apache.hadoop.hbase.master.HMaster.startActiveMasterManager(HMaster.java:2112)
	at org.apache.hadoop.hbase.master.HMaster.lambda$run$0(HMaster.java:580)
	at java.lang.Thread.run(Thread.java:748)
2022-12-23 04:39:15,048 INFO  [master/server1:16000:becomeActiveMaster] regionserver.HRegionServer: ***** STOPPING region server 'server1,16000,1671770343246' *****
2022-12-23 04:39:15,048 INFO  [master/server1:16000:becomeActiveMaster] regionserver.HRegionServer: STOPPED: Stopped by master/server1:16000:becomeActiveMaster
2022-12-23 04:39:15,049 INFO  [master/server1:16000] regionserver.HRegionServer: Stopping infoServer
2022-12-23 04:39:15,051 INFO  [master/server1:16000.splitLogManager..Chore.1] hbase.ScheduledChore: Chore: SplitLogManager Timeout Monitor was stopped
```

### Patch 

Status：Available

Link：[https://github.com/apache/hbase/pull/3541/commits/5d0b1accbe3007c8f6bffff8c654e8f2f44f1689](https://github.com/apache/hbase/pull/3541/commits/5d0b1accbe3007c8f6bffff8c654e8f2f44f1689)

Fix version：3.11.6

Regression testing path：Archive/Hbase/Hbase-23682/hbase-2.2.2-src/fix/
