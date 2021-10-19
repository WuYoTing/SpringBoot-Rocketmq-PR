<p align="center">
  <h2 align="center">SpringBoot-Rocketmq-PR</h2>
</p>
<p align="center">
   <img src="https://img.shields.io/badge/language-java-brightgreen?style"/>
</p>

## Overview

---

This project is a simple practice about SpringBoot & Rocketmq

## Setup

---

1. Set up localhost rocket mq [https://rocketmq.apache.org/docs/quick-start/](Quick Start)
2. Set up application.properties

```
aliyun.rocketmq.server=localhost:9876
spring.cloud.stream.rocketmq.binder.name-server=${aliyun.rocketmq.server}
# test-rocketmq-pub
spring.cloud.stream.bindings.test-rocketmq-pub.destination=rocketmq
# test-rocketmq-sub
spring.cloud.stream.bindings.test-rocketmq-sub.destination=rocketmq
spring.cloud.stream.bindings.test-rocketmq-sub.group=test
```

3. run spring application

Result
---
You can see the result below show in terminal

```
[MessageThread_1] c.e.d.i.e.SentMQMSGEventHandler          : ~~~~~~~~~~~~~~~~~~~~~~~~~~Receive the Event~~~~~~~~~~~~~~~~~~~~~~~~~~
[MessageThread_1] c.e.d.i.e.SentMQMSGEventHandler          : receiveEvent : Hello World
[MessageThread_1] c.e.d.i.e.SentMQMSGEventHandler          : ~~~~~~~~~~~~~~~~~~~~~~~~~~Process the Event~~~~~~~~~~~~~~~~~~~~~~~~~~
```