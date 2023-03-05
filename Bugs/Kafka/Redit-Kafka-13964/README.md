# Redit-Kafka-13964

### Details

Title: ***kafka-configs.sh end with UnsupportedVersionException when describing TLS user with quotas***

JIRA link：[https://issues.apache.org/jira/browse/KAFKA-13964](https://issues.apache.org/jira/browse/KAFKA-13964)

|         Label         | Value |      Label       |    Value     |
|:---------------------:|:-----:|:----------------:|:------------:|
|       **Type**        |  Bug  |   **Priority**   |    Minor     |
|      **Status**       | OPEN  |  **Resolution**  |  Unresolved  |
| **Affects Version/s** | 3.2.0 | **Fix Version/s** | admin, kraft|

### Description

Usage of kafka-configs.sh end with org.apache.kafka.common.errors.UnsupportedVersionException: The broker does not support DESCRIBE_USER_SCRAM_CREDENTIALS when describing TLS user with quotas enabled.

```
bin/kafka-configs.sh --bootstrap-server localhost:9092 --describe --user CN=encrypted-arnost` got status code 1 and stderr: ------ Error while executing config command with args '--bootstrap-server localhost:9092 --describe --user CN=encrypted-arnost' java.util.concurrent.ExecutionException: org.apache.kafka.common.errors.UnsupportedVersionException: The broker does not support DESCRIBE_USER_SCRAM_CREDENTIALS
```

STDOUT contains all necessary data, but the script itself ends with return code 1 and the error above. Scram-sha has not been configured anywhere in that case (not supported by KRaft). This might be fixed by adding support for scram-sha in the next version (not reproducible without KRaft enabled).

### Issue Links

is fixed by [KAFKA-14084](https://issues.apache.org/jira/browse/KAFKA-14084) Support SCRAM when using KRaft mode

### Testcase

Reproduced version：3.2.0

Steps to reproduce：
1. Start kafka in a three-node cluster using KRaft.
2. Run the command describing TLS user with quotas enabled in one of the docker containers, and the exception is thrown:
```
16:44:31.106 [main] ERROR i.r.samples.kafka13964.SampleTest - Error while executing config command with args '--bootstrap-server 10.2.0.4:9092 --describe --user CN=encrypted-arnost'
java.util.concurrent.ExecutionException: org.apache.kafka.common.errors.UnsupportedVersionException: The broker does not support DESCRIBE_USER_SCRAM_CREDENTIALS
	at java.util.concurrent.CompletableFuture.reportGet(CompletableFuture.java:357)
	at java.util.concurrent.CompletableFuture.get(CompletableFuture.java:1928)
	at org.apache.kafka.common.internals.KafkaFutureImpl.get(KafkaFutureImpl.java:180)
	at kafka.admin.ConfigCommand$.describeClientQuotaAndUserScramCredentialConfigs(ConfigCommand.scala:615)
	at kafka.admin.ConfigCommand$.describeConfig(ConfigCommand.scala:511)
	at kafka.admin.ConfigCommand$.processCommand(ConfigCommand.scala:329)
	at kafka.admin.ConfigCommand$.main(ConfigCommand.scala:98)
	at kafka.admin.ConfigCommand.main(ConfigCommand.scala)
Caused by: org.apache.kafka.common.errors.UnsupportedVersionException: The broker does not support DESCRIBE_USER_SCRAM_CREDENTIALS
```

### Patch 

Status：Someone submitted but not resolved

Link：[https://github.com/apache/kafka/pull/12196/commits/b74c68dc970e1a6edb4f11a7ce33c1538183d03e](https://github.com/apache/kafka/pull/12196/commits/b74c68dc970e1a6edb4f11a7ce33c1538183d03e)
