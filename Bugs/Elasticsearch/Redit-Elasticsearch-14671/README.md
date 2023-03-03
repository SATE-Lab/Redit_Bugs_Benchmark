# Redit-Elasticsearch-14671

### Details

Title: ***Do not allow stale replicas to automatically be promoted to primary***

github link: [https://github.com/elastic/elasticsearch/issues/14671](https://github.com/elastic/elasticsearch/issues/14671)

elasticsearch official resiliency page: [https://www.elastic.co/guide/en/elasticsearch/resiliency/current/index.html](https://www.elastic.co/guide/en/elasticsearch/resiliency/current/index.html)

### Description

#### Description from github

Consider a primary shard P hosted on node p and its replica shard Q hosted on node q. 
If p is isolated from the cluster (e.g., through node failure, a flapping NIC, or an excessively long garbage collection pause), 
indexing operations can continue on q after Q is promoted to primary; 
these indexing operations will be acknowledged to the requesting clients. 
If q is subsequently isolated before p rejoins and before a new replica is assigned to another node in the cluster, 
the subsequent rejoining of p can currently lead to P being promoted to primary again. 
The indexing operations acknowledged by q will be lost.

A mechanism needs to be built to prevent the automatic promotion of a stale shard in such a scenario and instead only promote a non-stale shard to primary (if a non-stale shard is availabie). 
The only scenario in which a stale shard should be promoted to primary is through manual intervention by a system operator (e.g., in cases when q suffers a total hardware failure).

Relates [#10933](https://github.com/elastic/elasticsearch/issues/10933)

#### Description from resiliency page

In some scenarios, after the loss of all valid copies, a stale replica shard can be automatically assigned as a primary, preferring old data to no data at all ([#14671](https://github.com/elastic/elasticsearch/issues/14671)). 
This can lead to a loss of acknowledged writes if the valid copies are not lost but are rather temporarily unavailable.

### Testcase

Reproduced version：1.3.0

Steps to reproduce：
1. Edit elasticsearch.yml and make the following changes
   - discovery.zen.fd.ping_timeout: 5
   - discovery.zen.fd.ping_retries: 1
   - index.number_of_replicas : 1
   - index.number_of_shards: 1
   The first two changes are intended to reduce testing time, and the other two are intended to reduce the number of shards and replicas.
2. Edit elasticsearch.yml for each node.
   For node-1, set `node.master:true` and `node.data:false`, and do the opposite for the other two nodes in order to make sure node-1 is the only master.
3. Start a 3-node elasticsearch cluster using Redit.
4. Create index `foo` which type is `bar`, then create a document with a key-value pair: `value: origin`.
5. Find out node with the primary shard using `/_cat/shards`, which is called as primaryShardServer in the following. 
   The other server with the replica shard is called replicaShardServer.
6. Apply a network partition using Redit. Disconnect network between primaryShardServer and the other two nodes.
7. Update the document on replicaShardServer, change the `value` field from `origin` to `something else`.
8. Kill replicaShardServer, then remove network partition and wait for primaryShardServer to rejoin the cluster.
9. Query shard information using `/_cat/shards` and the result shows that status of primary shard is "STARTED",
   meaning that old primary shard get promoted to primary again.
10. Query document information via master server, and it returns with the old value (`"value": "origin"`).

### Patch 

Status：Not provided
