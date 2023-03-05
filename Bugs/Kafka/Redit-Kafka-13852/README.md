# Redit-Kafka-13852

### Details

Title: ***Kafka Acl documentation bug for wildcard '*'***

JIRA link：[https://issues.apache.org/jira/browse/KAFKA-13852](https://issues.apache.org/jira/browse/KAFKA-13852)

|         Label         |        Value        |      Label      |        Value        |
|:---------------------:|:-------------------:|:---------------:|:-------------------:|
|       **Type**        |         Bug         |  **Priority**   |        Minor        |
|      **Status**       |      RESOLVED       | **Resolution**  |        Fixed        |
| **Affects Version/s** | 3.1.0, 3.2.0, 3.1.2 | **Fix Version/s** |      3.3.0        |

### Description

There is a Kafka Acl documentation bug for wildcard '*' in the Examples.

The bug is when we run the below script in one folder which is not empty, we can not set ACL correctly. However, it
works only the folder is empty.

We can find the scripts with wildcard '*' from the Kafka documentation.

```

// Adding Acls
> bin/kafka-acls.sh --authorizer-properties zookeeper.connect=localhost:2181 --add --allow-principal User:Peter --allow-host 198.51.200.1 --producer --topic *

// List Acls
> bin/kafka-acls.sh --authorizer-properties zookeeper.connect=localhost:2181 --list --topic *
```

Reproduce the issue:

1. Create a file foo.txt under an empty folder
2. Run the script to add an acl by using the wildcard resource '*'
3. We can find the resource name is 'foo.txt'. Not wildcard '*'

```
// code placeholder
(base)  hongwei.xiang@hongweixiang  ~/Downloads/test  ll
total 0
(base)  hongwei.xiang@hongweixiang  ~/Downloads/test  touch foo.txt
(base)  hongwei.xiang@hongweixiang  ~/Downloads/test  ll
total 0
-rw-r--r--  1 hongwei.xiang  345931250     0B Apr 23 19:05 foo.txt
(base)  hongwei.xiang@hongweixiang  ~/Downloads/test  ~/bin/kafka-acls.sh --authorizer-properties zookeeper.connect=localhost:2181 --add --allow-principal User:Peter --allow-host 198.51.200.1 --producer --topic *
Adding ACLs for resource `ResourcePattern(resourceType=TOPIC, name=foo.txt, patternType=LITERAL)`:
(principal=User:Peter, host=198.51.200.1, operation=WRITE, permissionType=ALLOW)
(principal=User:Peter, host=198.51.200.1, operation=CREATE, permissionType=ALLOW)
(principal=User:Peter, host=198.51.200.1, operation=DESCRIBE, permissionType=ALLOW)
Current ACLs for resource `ResourcePattern(resourceType=TOPIC, name=foo.txt, patternType=LITERAL)`:
(principal=User:Peter, host=198.51.200.1, operation=WRITE, permissionType=ALLOW)
(principal=User:Peter, host=198.51.200.1, operation=CREATE, permissionType=ALLOW)
(principal=User:Peter, host=198.51.200.1, operation=DESCRIBE, permissionType=ALLOW)
(base)  hongwei.xiang@hongweixiang  ~/Downloads/test  ~/bin/kafka-acls.sh --authorizer-properties zookeeper.connect=localhost:2181 --add --allow-principal User:Peter --allow-host 198.51.200.1 --topic * --producer
Adding ACLs for resource `ResourcePattern(resourceType=TOPIC, name=foo.txt, patternType=LITERAL)`:
(principal=User:Peter, host=198.51.200.1, operation=WRITE, permissionType=ALLOW)
(principal=User:Peter, host=198.51.200.1, operation=CREATE, permissionType=ALLOW)
(principal=User:Peter, host=198.51.200.1, operation=DESCRIBE, permissionType=ALLOW)
Current ACLs for resource `ResourcePattern(resourceType=TOPIC, name=foo.txt, patternType=LITERAL)`:
(principal=User:Peter, host=198.51.200.1, operation=WRITE, permissionType=ALLOW)
(principal=User:Peter, host=198.51.200.1, operation=CREATE, permissionType=ALLOW)
(principal=User:Peter, host=198.51.200.1, operation=DESCRIBE, permissionType=ALLOW)

(base)  hongwei.xiang@hongweixiang  ~/Downloads/test  ~/bin/kafka-acls.sh --authorizer-properties zookeeper.connect=localhost:2181 --list --topic *
Current ACLs for resource `ResourcePattern(resourceType=TOPIC, name=foo.txt, patternType=LITERAL)`:
(principal=User:Peter, host=198.51.200.1, operation=WRITE, permissionType=ALLOW)
(principal=User:Peter, host=198.51.200.1, operation=CREATE, permissionType=ALLOW)
(principal=User:Peter, host=198.51.200.1, operation=DESCRIBE, permissionType=ALLOW)
```

To resolve the issue:

Add single quotes for the wildcard '*' in the script.

```
(base)  hongwei.xiang@hongweixiang  ~/Downloads/test  ~/bin/kafka-acls.sh --authorizer-properties zookeeper.connect=localhost:2181 --add --allow-principal User:Peter --allow-host 198.51.200.1 --producer --topic '*'
Adding ACLs for resource `ResourcePattern(resourceType=TOPIC, name=*, patternType=LITERAL)`:
(principal=User:Peter, host=198.51.200.1, operation=WRITE, permissionType=ALLOW)
(principal=User:Peter, host=198.51.200.1, operation=CREATE, permissionType=ALLOW)
(principal=User:Peter, host=198.51.200.1, operation=DESCRIBE, permissionType=ALLOW)
Current ACLs for resource `ResourcePattern(resourceType=TOPIC, name=*, patternType=LITERAL)`:
(principal=User:Peter, host=198.51.200.1, operation=WRITE, permissionType=ALLOW)
(principal=User:Peter, host=198.51.200.1, operation=CREATE, permissionType=ALLOW)
(principal=User:Peter, host=198.51.200.1, operation=DESCRIBE, permissionType=ALLOW)


(base)  hongwei.xiang@hongweixiang  ~/Downloads/test  ~/bin/kafka-acls.sh --authorizer-properties zookeeper.connect=localhost:2181 --list --topic '*'
Current ACLs for resource `ResourcePattern(resourceType=TOPIC, name=*, patternType=LITERAL)`:
(principal=User:Peter, host=198.51.200.1, operation=WRITE, permissionType=ALLOW)
(principal=User:Peter, host=198.51.200.1, operation=CREATE, permissionType=ALLOW)
(principal=User:Peter, host=198.51.200.1, operation=DESCRIBE, permissionType=ALLOW)
I've submitted a pull request: "KAFKA-13852: Kafka Acl documentation bug for wildcard '*' #12090"
```

I've submitted a pull request: "KAFKA-13852: Kafka Acl documentation bug for wildcard '*' #12090"

### Testcase

Reproduced version：2.13-3.2.0

Steps to reproduce：
1. Start zookeeper and kafka in a three-node cluster.
2. Create two directories on "server 1", one is empty and the other is non-empty.
3. Run the script to add an acl by using the wildcard resource '*' in each of the two directories and compare the output, and the above exception is shown in command line.
4. The ACL of the non-empty directory is 'test.txt' rather than *:
```
16:39:50.712 [main] INFO  i.r.samples.kafka13852.SampleTest - server1: cd /kafka/kafka_2.13-3.2.0/test_not_empty && ../bin/kafka-acls.sh --authorizer-properties zookeeper.connect=10.2.0.4:2181,10.2.0.3:2181,10.2.0.2:2181 --add --allow-principal User:Peter --allow-host 198.51.200.1 --producer --topic *
16:39:50.712 [main] INFO  i.r.samples.kafka13852.SampleTest - Adding ACLs for resource `ResourcePattern(resourceType=TOPIC, name=test.txt, patternType=LITERAL)`:
 	(principal=User:Peter, host=198.51.200.1, operation=CREATE, permissionType=ALLOW)
	(principal=User:Peter, host=198.51.200.1, operation=WRITE, permissionType=ALLOW)
	(principal=User:Peter, host=198.51.200.1, operation=DESCRIBE, permissionType=ALLOW)

Current ACLs for resource `ResourcePattern(resourceType=TOPIC, name=test.txt, patternType=LITERAL)`:
 	(principal=User:Peter, host=198.51.200.1, operation=CREATE, permissionType=ALLOW)
	(principal=User:Peter, host=198.51.200.1, operation=WRITE, permissionType=ALLOW)
	(principal=User:Peter, host=198.51.200.1, operation=DESCRIBE, permissionType=ALLOW)


16:39:52.698 [main] INFO  i.r.samples.kafka13852.SampleTest - server1: cd /kafka/kafka_2.13-3.2.0/test_empty && ../bin/kafka-acls.sh --authorizer-properties zookeeper.connect=10.2.0.4:2181,10.2.0.3:2181,10.2.0.2:2181 --add --allow-principal User:Peter --allow-host 198.51.200.1 --producer --topic *
16:39:52.698 [main] INFO  i.r.samples.kafka13852.SampleTest - Adding ACLs for resource `ResourcePattern(resourceType=TOPIC, name=*, patternType=LITERAL)`:
 	(principal=User:Peter, host=198.51.200.1, operation=CREATE, permissionType=ALLOW)
	(principal=User:Peter, host=198.51.200.1, operation=WRITE, permissionType=ALLOW)
	(principal=User:Peter, host=198.51.200.1, operation=DESCRIBE, permissionType=ALLOW)

Current ACLs for resource `ResourcePattern(resourceType=TOPIC, name=*, patternType=LITERAL)`:
 	(principal=User:Peter, host=198.51.200.1, operation=CREATE, permissionType=ALLOW)
	(principal=User:Peter, host=198.51.200.1, operation=WRITE, permissionType=ALLOW)
	(principal=User:Peter, host=198.51.200.1, operation=DESCRIBE, permissionType=ALLOW)


16:39:54.572 [main] INFO  i.r.samples.kafka13852.SampleTest - server1: cd /kafka/kafka_2.13-3.2.0/test_not_empty && ../bin/kafka-acls.sh --authorizer-properties zookeeper.connect=10.2.0.4:2181,10.2.0.3:2181,10.2.0.2:2181 --list --topic *
16:39:54.572 [main] INFO  i.r.samples.kafka13852.SampleTest - Current ACLs for resource `ResourcePattern(resourceType=TOPIC, name=test.txt, patternType=LITERAL)`:
 	(principal=User:Peter, host=198.51.200.1, operation=CREATE, permissionType=ALLOW)
	(principal=User:Peter, host=198.51.200.1, operation=WRITE, permissionType=ALLOW)
	(principal=User:Peter, host=198.51.200.1, operation=DESCRIBE, permissionType=ALLOW)


16:39:56.348 [main] INFO  i.r.samples.kafka13852.SampleTest - server1: cd /kafka/kafka_2.13-3.2.0/test_empty && ../bin/kafka-acls.sh --authorizer-properties zookeeper.connect=10.2.0.4:2181,10.2.0.3:2181,10.2.0.2:2181 --list --topic *
16:39:56.348 [main] INFO  i.r.samples.kafka13852.SampleTest - Current ACLs for resource `ResourcePattern(resourceType=TOPIC, name=*, patternType=LITERAL)`:
 	(principal=User:Peter, host=198.51.200.1, operation=CREATE, permissionType=ALLOW)
	(principal=User:Peter, host=198.51.200.1, operation=WRITE, permissionType=ALLOW)
	(principal=User:Peter, host=198.51.200.1, operation=DESCRIBE, permissionType=ALLOW)
```

### Patch 

Status：Available

Link：[https://github.com/apache/kafka/pull/12090/commits/51db1aa5a03e0bf0ffd992a9146c08800eef0ac3](https://github.com/apache/kafka/pull/12090/commits/51db1aa5a03e0bf0ffd992a9146c08800eef0ac3)

Fix version：3.2.0

Regression testing path：Archive/Kafka/Kafka-13852/kafka-3.2.0-src/fix/
