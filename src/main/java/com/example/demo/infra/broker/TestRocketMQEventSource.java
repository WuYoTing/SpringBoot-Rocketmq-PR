package com.example.demo.infra.broker;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface TestRocketMQEventSource {

  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  final class Topic {

    public static final String TEST_ROCKETMQ_PUB = "test-rocketmq-pub";
    public static final String TEST_ROCKETMQ_SUB = "test-rocketmq-sub";
  }

  @Output(Topic.TEST_ROCKETMQ_PUB)
  MessageChannel testRocketMQMSGSent();

  @Input(Topic.TEST_ROCKETMQ_SUB)
  SubscribableChannel testRocketMQMSGSentSubscribable();
}
