# Redit-Kafka-7192

### Details

Title: ***State-store can desynchronise with changelog***

JIRA link：[https://issues.apache.org/jira/browse/KAFKA-7192](https://issues.apache.org/jira/browse/KAFKA-7192)

|         Label         |        Value        |      Label      |         Value          |
|:---------------------:|:-------------------:|:---------------:|:----------------------:|
|       **Type**        |         Bug         |  **Priority**   |         Critical          |
|      **Status**       |      RESOLVED       | **Resolution**  |         Fixed          |
| **Affects Version/s** | 0.11.0.3, 1.0.2, 1.1.1, 2.0.0 | **Fix Version/s** | 0.11.0.4, 1.0.3, 1.1.2, 2.0.1, 2.1.0 |

### Description

n.b. this bug has been verified with exactly-once processing enabled

Consider the following scenario:

- A record, N is read into a Kafka topology
- the state store is updated
- the topology crashes


Expected behaviour:

1. Node is restarted
2. Offset was never updated, so record N is reprocessed
3. State-store is reset to position N-1
4. Record is reprocessed


Actual Behaviour:

1. Node is restarted
2. Record N is reprocessed (good)
3. The state store has the state from the previous processing

I'd consider this a corruption of the state-store, hence the critical Priority, although High may be more appropriate.

I wrote a proof-of-concept here, which demonstrates the problem on Linux:

[https://github.com/spadger/kafka-streams-sad-state-store](https://github.com/spadger/kafka-streams-sad-state-store)

### Testcase

Through the reproduction of the given code logic, it is found that the topology collapse mentioned by the author actually refers to the collapse of the kafka stream. In the reproduction process, an exception is thrown to simulate its collapse. The node restart mentioned is actually the restart of the stream (topology). The experimental results show that the record N will be reprocessed, and the record storage already has the previous processing state.

### Patch

Status：Unavailable

The patch information is unclear, making it difficult to understand and reproduce the fix.
