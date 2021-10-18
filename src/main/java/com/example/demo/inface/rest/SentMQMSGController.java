package com.example.demo.inface.rest;


import com.example.demo.infra.broker.TestRocketMQEventSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SentMQMSGController {
    @Autowired
    TestRocketMQEventSource testRocketMQEventSource;

    @RequestMapping("/mqmsg/sent")
    public ResponseEntity<?> SentMSG() {
        // 生產者產出資料
        Boolean result = testRocketMQEventSource.testRocketMQMSGSent().send(
                MessageBuilder.withPayload("Hello World").build()
        );
        return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.OK);
    }
}
