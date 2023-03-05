# Redit-Kafka-13718

### Details

Title: ***kafka-topics describe topic with default config will show `segment.bytes` overridden config***

JIRA link：[https://issues.apache.org/jira/browse/KAFKA-13718](https://issues.apache.org/jira/browse/KAFKA-13718)

|         Label         |        Value        |      Label      |         Value          |
|:---------------------:|:-------------------:|:---------------:|:----------------------:|
|       **Type**        |         Bug         |  **Priority**   |         Major          |
|      **Status**       |      RESOLVED       | **Resolution**  |         Fixed          |
| **Affects Version/s** | 3.1.0, 2.8.1, 3.0.0 | **Fix Version/s** |        3.3.0         |

### Description

Following the quickstart [guide](https://kafka.apache.org/quickstart), when describing the topic just created with
default config, I found there's a overridden config shown:

```
> bin/kafka-topics.sh --describe --topic quickstart-events --bootstrap-server localhost:9092
```

Topic: quickstart-events TopicId: 06zRrzDCRceR9zWAf_BUWQ PartitionCount: 1 ReplicationFactor: 1 Configs:
segment.bytes=1073741824

Topic: quickstart-events Partition: 0 Leader: 0 Replicas: 0 Isr: 0

This config result should be empty as in Kafka quick start page. Although the config value is what we expected (default
1GB value), this info display still confuse users.

Note: I checked the 2.8.1 build, this issue also happened.

### Testcase

Reproduced version：2.13-3.2.0

Steps to reproduce：
1. Start zookeeper and kafka in a three-node cluster, then create topic 'test' in server no.1 with default config.
2. Describe the topic using '--describe --topic' command, the console displays additional information about segment bytes, but it should not be shown because of the default configuration.

### Patch 

Status：Available

Link：[https://github.com/apache/kafka/pull/12246/commits](https://github.com/apache/kafka/pull/12246/commits)

Fix version：3.2.0

The patch is a modification of a configuration file, not a system source package.
