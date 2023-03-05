# Redit-HBASE-26742

### Details

Title: ***Comparator of NOT_EQUAL NULL is invalid for checkAndMutate***

JIRA link：[https://issues.apache.org/jira/browse/HBASE-26742](https://issues.apache.org/jira/browse/HBASE-26742)

|         Label         |        Value        |      Label      |         Value          |
|:---------------------:|:-------------------:|:---------------:|:----------------------:|
|       **Type**        |         Bug         |  **Priority**   |         Major          |
|      **Status**       |      RESOLVED       | **Resolution**  |         Fixed          |
| **Affects Version/s** | 1.8.0 , 3.0.0-alpha-2 , 2.4.9 | **Fix Version/s** | 2.5.0, 3.0.0-alpha-3, 2.4.10 |

### Description

In server side, checkAndMutate ignores CompareOperator for null or empty comparator value, but NOT_EQUAL should be treated specially.

The check logic in HRegion#checkAndMutateInternal is as follows,

```
boolean valueIsNull =
  comparator.getValue() == null || comparator.getValue().length == 0;
if (result.isEmpty() && valueIsNull) {
  matches = true;
} else if (result.size() > 0 && result.get(0).getValueLength() == 0 && valueIsNull) {
  matches = true;
  cellTs = result.get(0).getTimestamp();
} else if (result.size() == 1 && !valueIsNull) {
  Cell kv = result.get(0);
  cellTs = kv.getTimestamp();
  int compareResult = PrivateCellUtil.compareValue(kv, comparator);
  matches = matches(op, compareResult);
}
```

For current logics, here are some  counter examples(Comparator value is set null),

1. result is null, operator is NOT_EQUAL, but matches is true;
2. result size >0, the value of the first cell is empty, operator is NOT_EQUAL, but matches is true;
3. result size is 1, operator is NOT_EQUAL, but matches is false;

### Testcase

Reproduced version：2.4.9

Steps to reproduce：
1. Connect to the cluster and get the admin object. 
2. Create a table, add test data to the table.
3. Use the checkAndMutate method to generate a Failure:
```
org.junit.ComparisonFailure: 
Expected :v1
Actual   :v0
<Click to see difference>

	at org.junit.Assert.assertEquals(Assert.java:115)
	at org.junit.Assert.assertEquals(Assert.java:144)
	at io.redit.samples.hbase26742.SampleTest.testCheckAndMutateForNull(SampleTest.java:113)
	at io.redit.samples.hbase26742.SampleTest.sampleTest(SampleTest.java:94)
	......
```

### Patch 

Status：To be tested

Due to local environment problems, the service domain name cannot be found when the HBASE client accesses the cluster.
