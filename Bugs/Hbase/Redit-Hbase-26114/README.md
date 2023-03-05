# Redit-HBASE-26114

### Details

Title: ***when “hbase.mob.compaction.threads.max” is set to a negative number, HMaster cannot start normally***

JIRA link：[https://issues.apache.org/jira/browse/HBASE-26114](https://issues.apache.org/jira/browse/HBASE-26114)

|         Label         |        Value        |      Label      |         Value          |
|:---------------------:|:-------------------:|:---------------:|:----------------------:|
|       **Type**        |         Bug         |  **Priority**   |         Minor          |
|      **Status**       |      RESOLVED       | **Resolution**  |         Fixed          |
| **Affects Version/s** |   2.2.0 ~ 2.4.4     | **Component/s** |        master          |

### Description

In hbase-default.xml：
```
<property>     
    <name>hbase.mob.compaction.threads.max</name>     
    <value>1</value>     
    <description>       
      The max number of threads used in MobCompactor.     
    </description>   
</property>
```

When the value is set to a negative number, such as -1, Hmaster cannot start normally.

The log file will output:
```
2021-07-22 18:54:13,758 ERROR [master/JavaFuzz:16000:becomeActiveMaster] master.HMaster: Failed to become active master java.lang.IllegalArgumentException            
    at java.util.concurrent.ThreadPoolExecutor.<init>(ThreadPoolExecutor.java:1314)                      at org.apache.hadoop.hbase.mob.MobUtils.createMobCompactorThreadPool(MobUtils.java:880)
    at org.apache.hadoop.hbase.master.MobCompactionChore.<init>
(MobCompactionChore.java:51)   at org.apache.hadoop.hbase.master.HMaster.initMobCleaner(HMaster.java:1278) 
  at org.apache.hadoop.hbase.master.HMaster.finishActiveMasterInitialization(HMaster.java:1161) 
    at org.apache.hadoop.hbase.master.HMaster.startActiveMasterManager(HMaster.java:2112)
    at org.apache.hadoop.hbase.master.HMaster.lambda$run$0(HMaster.java:580)
    at java.lang.Thread.run(Thread.java:748) 

2021-07-22 18:54:13,760 ERROR [master/JavaFuzz:16000:becomeActiveMaster] master.HMaster: Master server abort: loaded coprocessors are: [org.apache.hadoop.hbase.coprocessor.MultiRowMutationEndpoint] 
2021-07-22 18:54:13,760 ERROR [master/JavaFuzz:16000:becomeActiveMaster] master.HMaster: ***** ABORTING master javafuzz,16000,1626951243154: Unhandled exception. Starting shutdown. ***** java.lang.IllegalArgumentException     
    at java.util.concurrent.ThreadPoolExecutor.<init>(ThreadPoolExecutor.java:1314)   at org.apache.hadoop.hbase.mob.MobUtils.createMobCompactorThreadPool(MobUtils.java:880)     
    at org.apache.hadoop.hbase.master.MobCompactionChore.<init>(MobCompactionChore.java:51) 
  at org.apache.hadoop.hbase.master.HMaster.initMobCleaner(HMaster.java:1278) 
  at org.apache.hadoop.hbase.master.HMaster.finishActiveMasterInitialization(HMaster.java:1161) 
  at org.apache.hadoop.hbase.master.HMaster.startActiveMasterManager(HMaster.java:2112) 
    at org.apache.hadoop.hbase.master.HMaster.lambda$run$0(HMaster.java:580) 
  at java.lang.Thread.run(Thread.java:748) 

2021-07-
22 18:54:13,760 INFO  [master/JavaFuzz:16000:becomeActiveMaster] regionserver.HRegionServer: ***** STOPPING region server 'javafuzz,16000,1626951243154' *****
```

In MobUtils.java(package org.apache.hadoop.hbase.mob) 
This method from version 2.2.0 to version 2.4.4 is the same

```
  public static ExecutorService createMobCompactorThreadPool(Configuration conf) {     int maxThreads = conf.getInt(MobConstants.MOB_COMPACTION_THREADS_MAX,         MobConstants.DEFAULT_MOB_COMPACTION_THREADS_MAX);     
        if (maxThreads == 0) { 
           maxThreads = 1;    
       }     
        final SynchronousQueue<Runnable> queue = new SynchronousQueue<>();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, maxThreads, 60, TimeUnit.SECONDS, queue,       Threads.newDaemonThreadFactory("MobCompactor"), new RejectedExecutionHandler() {
       @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {           
            try {             
                // waiting for a thread to pick up instead of throwing exceptions.             
                queue.put(r);           
            } catch (InterruptedException e) {             
                throw new RejectedExecutionException(e);           
            }         
          }       
        });     
    ((ThreadPoolExecutor) pool).allowCoreThreadTimeOut(true);     
    return pool;   
   }
```

When MOB_COMPACTION_THREADS_MAX is set to 0, mobUtil will set it to 1. But the program does not take into account that it is set to a negative number. When it is set to a negative number, the initialization of the ThreadPoolExecutor will fail and an IllegalArgumentException will be thrown, making HMaster fail to start.

Sometimes users will use -1 as the value of the default item in the configuration file.

Therefore, it is best to modify the source code, when the value is negative, also set its maxThread to 1.

Only need to modify 

    if (maxThreads == 0) {

to 

    if (maxThreads <= 0) {


### Testcase

Reproduced version：2.2.2

Steps to reproduce：
1. Configure in hbase-site.xml:
```
<property>
    <name>hbase.mob.compaction.threads.max</name>
    <value>-1</value>
    <description>
      The max number of threads used in MobCompactor.
    </description>
  </property>
```
2. Start the hdfs cluster, the zookeeper cluster and the hbase cluster in turn, and throw the above exception when the master starts:
```
2022-12-23 05:51:51,590 INFO  [master/server2:16000:becomeActiveMaster] zookeeper.ZKWatcher: not a secure deployment, proceeding
2022-12-23 05:51:51,592 ERROR [master/server2:16000:becomeActiveMaster] master.HMaster: Failed to become active master
java.lang.IllegalArgumentException
	at java.util.concurrent.ThreadPoolExecutor.<init>(ThreadPoolExecutor.java:1314)
	at org.apache.hadoop.hbase.mob.MobUtils.createMobCompactorThreadPool(MobUtils.java:880)
	at org.apache.hadoop.hbase.master.MobCompactionChore.<init>(MobCompactionChore.java:51)
	at org.apache.hadoop.hbase.master.HMaster.initMobCleaner(HMaster.java:1278)
	at org.apache.hadoop.hbase.master.HMaster.finishActiveMasterInitialization(HMaster.java:1161)
	at org.apache.hadoop.hbase.master.HMaster.startActiveMasterManager(HMaster.java:2112)
	at org.apache.hadoop.hbase.master.HMaster.lambda$run$0(HMaster.java:580)
	at java.lang.Thread.run(Thread.java:748)
2022-12-23 05:51:51,592 ERROR [master/server2:16000:becomeActiveMaster] master.HMaster: Master server abort: loaded coprocessors are: []
2022-12-23 05:51:51,592 ERROR [master/server2:16000:becomeActiveMaster] master.HMaster: ***** ABORTING master server2,16000,1671774698160: Unhandled exception. Starting shutdown. *****
java.lang.IllegalArgumentException
	at java.util.concurrent.ThreadPoolExecutor.<init>(ThreadPoolExecutor.java:1314)
	at org.apache.hadoop.hbase.mob.MobUtils.createMobCompactorThreadPool(MobUtils.java:880)
	at org.apache.hadoop.hbase.master.MobCompactionChore.<init>(MobCompactionChore.java:51)
	at org.apache.hadoop.hbase.master.HMaster.initMobCleaner(HMaster.java:1278)
	at org.apache.hadoop.hbase.master.HMaster.finishActiveMasterInitialization(HMaster.java:1161)
	at org.apache.hadoop.hbase.master.HMaster.startActiveMasterManager(HMaster.java:2112)
	at org.apache.hadoop.hbase.master.HMaster.lambda$run$0(HMaster.java:580)
	at java.lang.Thread.run(Thread.java:748)
2022-12-23 05:51:51,592 INFO  [master/server2:16000:becomeActiveMaster] regionserver.HRegionServer: ***** STOPPING region server 'server2,16000,1671774698160' *****
2022-12-23 05:51:51,592 INFO  [master/server2:16000:becomeActiveMaster] regionserver.HRegionServer: STOPPED: Stopped by master/server2:16000:becomeActiveMaster
2022-12-23 05:51:51,593 INFO  [master/server2:16000] regionserver.HRegionServer: Stopping infoServer
```

### Patch 

Status：Available

Link：[https://github.com/apache/hbase/pull/3541/commits/5d0b1accbe3007c8f6bffff8c654e8f2f44f1689](https://github.com/apache/hbase/pull/3541/commits/5d0b1accbe3007c8f6bffff8c654e8f2f44f1689)

Fix version：2.2.2

Regression testing path：Archive/Hbase/Hbase-26114/hbase-2.2.2-src/fix/
