package com.example.demo.inface.rest;


import com.example.demo.inface.event.SentMQMSGEventHandler;
import com.example.demo.inface.rest.dto.Response;
import com.example.demo.infra.broker.TestRocketMQEventSource;
import java.util.HashMap;
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
  public ResponseEntity<Response> SentMSG() {
    // 生產者產出資料
    Boolean result = testRocketMQEventSource.testRocketMQMSGSent()
        .send(MessageBuilder.withPayload("Hello World").build());
    logger.info("~~~~~~~~~~~~~~~~~~~~~~~~~~Send Message Event~~~~~~~~~~~~~~~~~~~~~~~~~~");
    HashMap<String, Object> resp = new HashMap<String, Object>();
    if (result) {
      return new ResponseEntity<>(new Response("success", ""), new HttpHeaders(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(new Response("error", ""), new HttpHeaders(),
          HttpStatus.BAD_REQUEST);
    }
  }
}
