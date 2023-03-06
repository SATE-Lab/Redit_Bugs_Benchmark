# Redit-Zookeeper-4466

### Details

Title: ***Watchers of different modes interfere on overlapping pathes***

JIRA link：[https://issues.apache.org/jira/browse/ZOOKEEPER-4466](https://issues.apache.org/jira/browse/ZOOKEEPER-4466)

|         Label         |    Value     | Label           |       Value        |
|:---------------------:|:------------:|:---------------:|:------------------:|
|       **Type**        |     Bug      | **Priority**    |       Major        |
|      **Status**       |     OPEN     | **Resolution**  |     Unresolved     |
| **Affects Version/s** | 3.6.3, 3.7, 3.6.4 | **Fix Version/s** |    None     |

### Description
I used to think watchers of different modes are orthogonal. I found there are not, when I wrote tests for unfinished rust client. And I wrote test cases in java and confirmed.

I copied test case here for evaluation. You also clone from my fork.

```
    // zookeeper-server/src/test/java/org/apache/zookeeper/test/PersistentRecursiveWatcherTest.java

    @Test
    public void testPathOverlapWithStandardWatcher() throws Exception {
        try (ZooKeeper zk = createClient(new CountdownWatcher(), hostPort)) {
            CountDownLatch nodeCreated = new CountDownLatch(1);
            zk.addWatch("/a", persistentWatcher, PERSISTENT_RECURSIVE);
            zk.exists("/a", event -> nodeCreated.countDown());

            zk.create("/a", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            zk.create("/a/b", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            zk.delete("/a/b", -1);
            zk.delete("/a", -1);

            assertEvent(events, Watcher.Event.EventType.NodeCreated, "/a");
            assertEvent(events, Watcher.Event.EventType.NodeCreated, "/a/b");
            assertEvent(events, Watcher.Event.EventType.NodeDeleted, "/a/b");
            assertEvent(events, Watcher.Event.EventType.NodeDeleted, "/a");

            assertTrue(nodeCreated.await(5, TimeUnit.SECONDS));
        }
    }

    @Test
    public void testPathOverlapWithPersistentWatcher() throws Exception {
        try (ZooKeeper zk = createClient(new CountdownWatcher(), hostPort)) {
            zk.addWatch("/a", persistentWatcher, PERSISTENT_RECURSIVE);
            zk.addWatch("/a/b", event -> {}, PERSISTENT);
            zk.create("/a", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            zk.create("/a/b", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            zk.create("/a/b/c", new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            zk.delete("/a/b/c", -1);
            zk.delete("/a/b", -1);
            zk.delete("/a", -1);
            assertEvent(events, Watcher.Event.EventType.NodeCreated, "/a");
            assertEvent(events, Watcher.Event.EventType.NodeCreated, "/a/b");
            assertEvent(events, Watcher.Event.EventType.NodeCreated, "/a/b/c");
            assertEvent(events, Watcher.Event.EventType.NodeDeleted, "/a/b/c");
            assertEvent(events, Watcher.Event.EventType.NodeDeleted, "/a/b");
            assertEvent(events, Watcher.Event.EventType.NodeDeleted, "/a");
        }
    }
```

I skimmed the code and found two possible causes:

1. ZKWatchManager.materialize materializes all persistent watchers(include recursive ones) for NodeChildrenChanged event.
2. WatcherModeManager trackes only one watcher mode.

### Testcase

Reproduced version：3.7.1

Two testcases to reproduce：
1. Start a three-node zookeeper cluster, create a client and add two watchers for path `/a`: a persistent recursive watcher and a standard watcher. Next we create and delete some nodes and monitor the changes in the event queue recorded by persistent recursive watcher. The result shows that the event queue attached to the persistent recursive watcher is affected by both of the watchers.
2. Similar to 1, but the two watchers are the persistent recursive watcher added to path `/a` and the persistent watcher added to path `/a/b`. The results are also similar to 1.

### Patch 

Status：Not submitted
