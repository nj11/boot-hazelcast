## Hazelcast distributed cache with spring boot microservices

## Make sure the eureka service is running

```http://localhost:8761/```

### Run 2 different instances of hazel cast client and they are connected to eureka service
```java -jar target/hazelcast-node-0.0.1-SNAPSHOT.jar --server.port=8082```

```java -jar target/hazelcast-node-0.0.1-SNAPSHOT.jar --server.port=8083```

### Run the rest endpoint to retrieve bookname by isbn.First time it connects and cache is not initialized the fetch takes longer than subsequent attempts.

```http://localhost:8082/books/ISBN123```

```http://localhost:8083/books/ISBN123```

### Application startup hazelcast log preview 
```
2021-04-14 13:43:05.977  INFO 3032 --- [           main] com.hazelcast.system                     : [192.168.86.23]:5702 [dev] [3.11] Hazelcast 3.11 (20181023 - 1500bbb) starting at [192.168.86.23]:5702
2021-04-14 13:43:05.979  INFO 3032 --- [           main] com.hazelcast.system                     : [192.168.86.23]:5702 [dev] [3.11] Copyright (c) 2008-2018, Hazelcast, Inc. All Rights Reserved.
2021-04-14 13:43:05.986  INFO 3032 --- [           main] com.hazelcast.instance.Node              : [192.168.86.23]:5702 [dev] [3.11] A non-empty group password is configured for the Hazelcast member. Starting with Hazelcast version 3.8.2, members with the same group name, but with different group passwords (that do not use authentication) form a cluster. The group password configuration will be removed completely in a future release.
2021-04-14 13:43:06.495  INFO 3032 --- [           main] c.h.s.i.o.impl.BackpressureRegulator     : [192.168.86.23]:5702 [dev] [3.11] Backpressure is disabled
2021-04-14 13:43:07.297  INFO 3032 --- [           main] com.hazelcast.instance.Node              : [192.168.86.23]:5702 [dev] [3.11] Creating MulticastJoiner
2021-04-14 13:43:07.447  INFO 3032 --- [           main] c.h.s.i.o.impl.OperationExecutorImpl     : [192.168.86.23]:5702 [dev] [3.11] Starting 12 partition threads and 7 generic threads (1 dedicated for priority tasks)
2021-04-14 13:43:07.451  INFO 3032 --- [           main] c.h.internal.diagnostics.Diagnostics     : [192.168.86.23]:5702 [dev] [3.11] Diagnostics disabled. To enable add -Dhazelcast.diagnostics.enabled=true to the JVM arguments.
2021-04-14 13:43:07.467  INFO 3032 --- [           main] com.hazelcast.core.LifecycleService      : [192.168.86.23]:5702 [dev] [3.11] [192.168.86.23]:5702 is STARTING
2021-04-14 13:43:07.612  INFO 3032 --- [           main] c.h.i.cluster.impl.MulticastJoiner       : [192.168.86.23]:5702 [dev] [3.11] Trying to join to discovered node: [192.168.86.23]:5701
2021-04-14 13:43:07.623  INFO 3032 --- [cached.thread-1] com.hazelcast.nio.tcp.TcpIpConnector     : [192.168.86.23]:5702 [dev] [3.11] Connecting to /192.168.86.23:5701, timeout: 0, bind-any: true
2021-04-14 13:43:07.653  INFO 3032 --- [.IO.thread-in-0] com.hazelcast.nio.tcp.TcpIpConnection    : [192.168.86.23]:5702 [dev] [3.11] Initialized new cluster connection between /192.168.86.23:57073 and /192.168.86.23:5701
2021-04-14 13:43:13.632  INFO 3032 --- [ration.thread-0] c.h.internal.cluster.ClusterService      : [192.168.86.23]:5702 [dev] [3.11]

Members {size:2, ver:2} [
        Member [192.168.86.23]:5701 - a36d7852-8871-4535-b89d-898ebb793318
        Member [192.168.86.23]:5702 - c7701c3c-05f3-42d5-88fd-d672df588f7a this
]
```
