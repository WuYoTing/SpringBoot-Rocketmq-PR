package com.example.demo.inface.event;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.example.demo.infra.broker.TestRocketMQEventSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(TestRocketMQEventSource.class)
public class SentMQMSGEventHandler {

  public static final Logger logger = LogManager.getLogger(SentMQMSGEventHandler.class);

  @StreamListener(target = TestRocketMQEventSource.Topic.TEST_ROCKETMQ_SUB)
  public void receiveEvent(@Payload String message) {
    // Process the Event
    logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~Receive the Event~~~~~~~~~~~~~~~~~~~~~~~~~~");
    //PcnReferenceCreatedEventData eventData = event.getData();

    String msg = "receiveEvent : " + message;

    logger.error(msg);
    logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~Process the Event~~~~~~~~~~~~~~~~~~~~~~~~~~");
  }
}
