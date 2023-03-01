# Redit-ActiveMQ-8252

### Details

Title: ***Unnecessary stack trace in case of invalid credentials***

JIRA link：[https://issues.apache.org/jira/browse/AMQ-6430](https://issues.apache.org/jira/browse/AMQ-6430)

|         Label         | Value  |      Label      |  Value   |
|:---------------------:|:------:|:---------------:|:--------:|
|       **Type**        |    Bug     |  **Priority**     |    Major       |
|      **Status**       |   Fixed    | **Resolution**    |   Resolved     |
| **Affects Version/s** |   5.16.2   | **Fix Version/s** | 5.16.4, 5.17.0 |

### Description

In case an invalid credential is used with STOMP, we get an unnecessary stack trace:

```
2021-04-28T09:17:07.020+0200 [ActiveMQ NIO Worker 0] WARN TransportConnection - Failed to add Connection id=ID:foo-29852-1619594148588-1:17, clientId=ID:foo-29852-1619594148588-1:17, clientIP=tcp://10.0.0.1:50940 due to User name [system] or password is invalid.
2021-04-28T09:17:07.020+0200 [ActiveMQ NIO Worker 0] WARN Service - Security Error occurred on connection to: tcp://10.0.0.1:50940, User name [system] or password is invalid.
2021-04-28T09:17:07.029+0200 [ActiveMQ NIO Worker 0] WARN Transport - Transport Connection to: tcp://10.0.0.1:50940 failed
java.io.IOException: User name [system] or password is invalid.
	at org.apache.activemq.util.IOExceptionSupport.create(IOExceptionSupport.java:40)
	...
Caused by: javax.security.auth.login.FailedLoginException: Password does not match
	at org.apache.activemq.jaas.PropertiesLoginModule.login(PropertiesLoginModule.java:95)
	...
```

This seems to be a regression because this problem was fixed as part of AMQ-7303.

### Testcase

Reproduced version：5.15.9

Steps to reproduce：
1. Edit activemq.xml in ./conf folder, add authentication configuration:

```xml
    <plugins>
        <simpleAuthenticationPlugin>
            <users>
                <authenticationUser username="admin" password="12345678" groups="users,admins"/>
            </users>
        </simpleAuthenticationPlugin>
    </plugins>
```

2. Then, start a 2-node activemq cluster using Redit, try to connect the nodes using `StompConnection` with wrong password.
3. After that, `java.lang.Exception: Not connected` is shown in the console.
4. There is unnecessary stack trace:

```
2023-01-04 09:59:01,280 | INFO  | Connector vm://brokerA started | org.apache.activemq.broker.TransportConnector | ActiveMQ Task-3
2023-01-04 09:59:01,287 | WARN  | Failed to add Connection id=brokerA->brokerB-40161-1672826337291-14:1, clientId=brokerB_brokerB_inbound_brokerA due to {} | org.apache.activemq.broker.TransportConnection | triggerStartAsyncNetworkBridgeCreation: remoteBroker=tcp:///10.2.0.2:61616@47580, localBroker= vm://brokerA#32
java.lang.SecurityException: User name [null] or password is invalid.
	at org.apache.activemq.security.SimpleAuthenticationBroker.authenticate(SimpleAuthenticationBroker.java:103)[activemq-broker-5.15.9.jar:5.15.9]
	...
```

### Patch 

Status：Available

Link：[https://github.com/apache/activemq/pull/413/commits/d95bb02f4704e9e51acc63ecd186e90b2b4a833c](https://github.com/apache/activemq/pull/413/commits/d95bb02f4704e9e51acc63ecd186e90b2b4a833c) [https://github.com/apache/activemq/pull/500/commits/945cd6b7de20cbc0a092eaa2e6dff5dfacc9acc3](https://github.com/apache/activemq/pull/500/commits/945cd6b7de20cbc0a092eaa2e6dff5dfacc9acc3)

Fix version：5.15.9

Regression testing path：Archive/Activemq/Activemq-8252/activemq-parent-5.15.9-src/fix/
