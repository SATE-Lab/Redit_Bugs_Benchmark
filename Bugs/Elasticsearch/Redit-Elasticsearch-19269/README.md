# Redit-Elasticsearch-19269

### Details

Title: ***_version does not uniquely identify a particular version of a document***

Github link: [https://github.com/elastic/elasticsearch/issues/19269](https://github.com/elastic/elasticsearch/issues/19269)

Elasticsearch official resiliency page: [https://www.elastic.co/guide/en/elasticsearch/resiliency/current/index.html](https://www.elastic.co/guide/en/elasticsearch/resiliency/current/index.html)

### Description

#### Description from github

@aphyr recently discovered this resilience issue [https://github.com/crate/crate/issues/3711] while running the jespen test suite against Crate.
After I created an integration test (based on current ES master) [https://github.com/crate/elasticsearch/commit/41ed5ebe7304710fda4de4e69479e17081042c38] out of the relevant jepsen code using your nice network partition simulation helper, I was able to reproduce this error not only using Crate but also using plain Elasticsearch.

I've reproduced this issue on ES 2.3, 5.0-alpha3 & master.
The longer the test is running the more often it will fail, with current default runtime of 180sec it fails almost always on my machine. (the relevant jepsen test is running 360sec)

Currently I've no real idea why this is happening, my guess is that some reads are reading a stale version value but I did not yet figured out how/why.
I've also run this scenario on a single node with one shard because my first guess was that this is maybe not network partition related but this test never failed..

I've read the current ES resilience issues and I couldn't see anything which could be related to this issue, but I'm also not completely sure.

#### Description from resiliency page

When a primary has been partitioned away from the cluster there is a short period of time until it detects this. 
During that time it will continue indexing writes locally, thereby updating document versions. 
When it tries to replicate the operation, however, it will discover that it is partitioned away. 
It won’t acknowledge the write and will wait until the partition is resolved to negotiate with the master on how to proceed. 
The master will decide to either fail any replicas which failed to index the operations on the primary or tell the primary that it has to step down because a new primary has been chosen in the meantime. 
Since the old primary has already written documents, clients may already have read from the old primary before it shuts itself down. 
The _version field of these reads may not uniquely identify the document’s version if the new primary has already accepted writes for the same document (see [#19269](https://github.com/elastic/elasticsearch/issues/19269)).

## Testcase

Elasticsearch version: 2.3.0

1. Edit elasticsearch.yml and make the following changes
    - discovery.zen.fd.ping_timeout: 5s
    - discovery.zen.fd.ping_retries: 1
    - index.number_of_replicas : 1
    - index.number_of_shards: 1
   The first two changes are intended to reduce testing time, and the other two are intended to reduce the number of shards and replicas.
2. Edit elasticsearch.yml for each node. 
For node-1, set `node.master:true` and `node.data:false`, and do the opposite for the other two nodes in order to make sure node-1 is the only master.
3. Start a 3-node elasticsearch cluster using Redit.
4. Create index `foo` which type is `bar`, then create a document with a key-value pair: `value: origin`, then retrieve that document, it will return with `_version: 1`.
5. Find out node with the primary shard using `curl localhost:9200/_cat/shards`, which is called as primaryShardServer in the following.
6. Apply a network partition using Redit. Disconnect network between primaryShardServer and the other two nodes.
7. Update the document on primaryShardServer, change the `value` field from `origin` to `dirty value`.
8. Try to query the document on the primaryShardServer, after several attempts, we will get a response containing `value: dirty value` with `_version: 2`
9. Try to update the document via master server, change the "value" field to "something else" in the request.
10. Remove the network partition, and wait a few seconds for primaryShardServer to rejoin the cluster.
11. Try to query the document via master server, it will return `something else` with `_version:2`.

### Patch 

Status：Not provided



