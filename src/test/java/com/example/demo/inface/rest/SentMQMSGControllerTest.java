package com.example.demo.inface.rest;


import com.example.demo.infra.broker.TestRocketMQEventSource;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class SentMQMSGControllerTest {


  RestTemplate restTemplate;

  @Mock
  TestRocketMQEventSource testRocketMQEventSource;

  public SentMQMSGControllerTest(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }


  @Test
  void sentMSG_should_receive_HTTP_OK_and_true() {
    // Arrange
    Message message = MessageBuilder.withPayload("Hello World").build();
    Mockito.when(testRocketMQEventSource.testRocketMQMSGSent().send(message)).thenReturn(true);

    // Act
    // this.restTemplate.getForObject("http://localhost:8080/services/{id}");

    // Assert

  }
}