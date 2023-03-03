# Redit-Elasticsearch-minimum-master-nodes

### Details

Title: ***Don't accept a dynamic update to min_master_nodes which is larger then current master node count***

Github link: [https://github.com/elastic/elasticsearch/pull/8321](https://github.com/elastic/elasticsearch/pull/8321)

Elasticsearch official resiliency page: [https://www.elastic.co/guide/en/elasticsearch/resiliency/current/index.html](https://www.elastic.co/guide/en/elasticsearch/resiliency/current/index.html)

### Description

#### Description from github

The discovery.zen.minimum_master_nodes setting can be updated dynamically. Settings it to a value higher then the current number of master nodes will cause the current master to step down. This is dangerous because if done by mistake (typo) there is no way to restore the settings (this requires an active master).

#### Description from resiliency page

Setting zen.discovery.minimum_master_nodes to a value higher than the current node count effectively leaves the cluster without a master and unable to process requests. 
The only way to fix this is to add more master-eligible nodes. [#8321](https://github.com/elastic/elasticsearch/issues/8321) adds a mechanism to validate settings before applying them, and [#9051](https://github.com/elastic/elasticsearch/issues/9051) extends this validation support to settings applied during a cluster restore. 
(STATUS: DONE, Fixed in v1.5.0)

### Testcase

Reproduced version：1.4.5

Steps to reproduce：
1. Set discovery.zen.minimum_master_nodes to 3 in elasticsearch.yml.
2. Start a 3-node elasticsearch cluster using Redit, send some commands to the cluster like creating an index. The cluster is fully functional.
3. Kill one of the three nodes, then keep on querying the status of one of the other two nodes using `curl -X GET http://localhost:9200/?pretty` for a while. The `status` field of the response is always 503, and neither node can perform properly to any request.
4. Check logs of those nodes, we can find out that after killing one of the nodes, elasticsearch assumes that eligible master node is not enough (`not enough master nodes` is recorded in log ).Because the current node count (2) is less than the value we set (discovery.zen.minimum_master_nodes: 3). So the cluster refuses to enter election phase and thus unable to perform any requests.

### Patch 

Status：Unavailable

Link：[https://github.com/elastic/elasticsearch/pull/8321/commits/31c2f55724be555fcd37ed42cf9b6e3b05705fdb](https://github.com/elastic/elasticsearch/pull/8321/commits/31c2f55724be555fcd37ed42cf9b6e3b05705fdb)

The official version 1.5.0 fixed this defect by adding verification, which does not solve this problem in my opinion. When a node in the cluster exits due to a crash, the cluster still cannot elect a new master. I verified this on version 1.5.0 and filed this issue on the Elastic website: 
[https://discuss.elastic.co/t/prevent-setting-minimum-master-nodes-to-more-than-the-current-node-count/326536](https://discuss.elastic.co/t/prevent-setting-minimum-master-nodes-to-more-than-the-current-node-count/326536)


