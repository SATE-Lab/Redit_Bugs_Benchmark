# Redit-Elasticsearch-14671

### Details

Title: ***Do not allow stale replicas to automatically be promoted to primary***

Github link: [https://github.com/elastic/elasticsearch/issues/2488](https://github.com/elastic/elasticsearch/issues/2488)

Elasticsearch official resiliency page: [https://www.elastic.co/guide/en/elasticsearch/resiliency/current/index.html](https://www.elastic.co/guide/en/elasticsearch/resiliency/current/index.html)

### Description

#### Description from github

I'm using ElasticSearch 0.19.11 with the unicast Zen discovery protocol.

With this setup, I can easily split a 3-node cluster into two 'hemispheres' (continuing with the brain metaphor) with one node acting as a participant in both hemispheres. I believe this to be a significant problem, because now minimum_master_nodes is incapable of preventing certain split-brain scenarios.

Here's what my 3-node test cluster looked like before I broke it:

Here's what the cluster looked like after simulating a communications failure between nodes (2) and (3):

Here's what seems to have happened immediately after the split:

Node (2) and (3) lose contact with one another. (zen-disco-node_failed ... reason failed to ping)
Node (2), still master of the left hemisphere, notes the disappearance of node (3) and broadcasts an advisory message to all of its followers. Node (1) takes note of the advisory.
Node (3) has now lost contact with its old master and decides to hold an election. It declares itself winner of the election. On declaring itself, it assumes master role of the right hemisphere, then broadcasts an advisory message to all of its followers. Node (1) takes note of this advisory, too.
At this point, I can't say I know what to expect to find on node (1). If I query both masters for a list of nodes, I see node (1) in both clusters.

Let's look at minimum_master_nodes as it applies to this test cluster. Assume I had set minimum_master_nodes to 2. Had node (3) been completely isolated from nodes (1) and (2), I would not have run into this problem. The left hemisphere would have enough nodes to satisfy the constraint; the right hemisphere would not. This would continue to work for larger clusters (with an appropriately larger value for minimum_master_nodes).

The problem with minimum_master_nodes is that it does not work when the split brains are intersecting, as in my example above. Even on a larger cluster of, say, 7 nodes with minimum_master_nodes set to 4, all that needs to happen is for the 'right' two nodes to lose contact with one another (a master election has to take place) for the cluster to split.

Is there anything that can be done to detect the intersecting split on node (1)?

Would #1057 help?

#### Description from resiliency page

Even when minimum master nodes is set, split brain can still occur under certain conditions, e.g. disconnection between master eligible nodes, which can lead to data loss. The scenario is described in detail in issue 2488:

- Introduce a new testing infrastructure to simulate different types of node disconnections, including loss of network connection, lost messages, message delays, etc. See MockTransportService support and service disruption for more details. (STATUS: DONE, v1.4.0.Beta1).
- Added tests that simulated the bug described in issue 2488. You can take a look at the original commit of a reproduction on master. (STATUS: DONE, v1.2.0)
- The bug described in issue 2488 is caused by an issue in our zen discovery gossip protocol. This specific issue has been fixed, and work has been done to make the algorithm more resilient. (STATUS: DONE, v1.4.0.Beta1)

### Testcase

Reproduced version：1.3.0

Steps to reproduce：
1. Edit elasticsearch.yml and make the following changes:
    - discovery.zen.minimum_master_nodes: 2
    - discovery.zen.fd.ping_timeout: 7
    - discovery.zen.fd.ping_retries: 2
2. Start a 3-node elasticsearch cluster using Redit and find out master server in the cluster using `curl localhost:9200/_cat/master?v`
3. Disconnect network between master and one of the follower.
4. If that follower elects itself as the new master, there will be 2 masters in the cluster at the same time according to description.
5. Run `curl localhost:9200/_cat/master?v` within the master and the follower which thinks itself to be the master, and two different master ip addresses is shown in the console.
6. This result also reveled by the log files of the 3 nodes, in which 2 nodes declared themselves as a master.

**Noted that due to the election mechanism of elasticsearch, not every single test can trigger this bug.**

### Patch 

Status：Not provided

After verification, this bug has been fixed in v1.4.0.Beta1.

