package com.example.demo.inface.rest;


import com.example.demo.inface.event.SentMQMSGEventHandler;
import com.example.demo.infra.broker.TestRocketMQEventSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SentMQMSGController {

  public static final Logger logger = LogManager.getLogger(SentMQMSGEventHandler.class);

  TestRocketMQEventSource testRocketMQEventSource;

  @Autowired
  public SentMQMSGController(TestRocketMQEventSource testRocketMQEventSource) {
    this.testRocketMQEventSource = testRocketMQEventSource;
  }

  /**
   * sent simple message queue
   *
   * @return ResponseEntity
   */
  @GetMapping("/mqmsg/sent")
  public ResponseEntity<?> SentMSG() {
    // 生產者產出資料
    Boolean result = testRocketMQEventSource.testRocketMQMSGSent().send(MessageBuilder.withPayload("Hello World").build());
    logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~Send Message Event~~~~~~~~~~~~~~~~~~~~~~~~~~");
    return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.OK);
  }
}
