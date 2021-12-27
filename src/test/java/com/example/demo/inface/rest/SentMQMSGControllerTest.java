package com.example.demo.inface.rest;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.inface.rest.dto.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import com.example.demo.infra.broker.TestRocketMQEventSource;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("SentMQMSGController")
class SentMQMSGControllerTest {

  private MockMvc mockMvc;

  @Mock
  TestRocketMQEventSource testRocketMQEventSource;

  @Mock
  MessageChannel messageChannel;

  @Autowired
  public SentMQMSGControllerTest(MockMvc mockMvc) {
    this.mockMvc = mockMvc;
  }

  @Nested
  @DisplayName("sentMSG")
  class sentMSG_test {

    @Test
    @DisplayName("sentMSG_should_send_message_and_is_ok")
    public void sentMSG_should_send_message_and_is_ok() throws Exception {
      // Arrange
      String resp = new Response("success", "").toString();
      Message<String> MsbBuild = MessageBuilder.withPayload("Hello").build();

      when(testRocketMQEventSource.testRocketMQMSGSent()).thenReturn(messageChannel);
      when(messageChannel.send(any())).thenReturn(true);

      // Act & Assert
      mockMvc.perform(get("/mqmsg/sent"))
          .andExpect(status().isOk())
          .andExpect(content().contentType("application/json"))
          .andExpect(jsonPath("$.status").value("success"))
          .andExpect(jsonPath("$.data").value(""));
    }

    @Test
    @DisplayName("sentMSG_should_send_message_and_is_bad_request")
    public void sentMSG_should_send_message_and_is_bad_request() throws Exception {
      // Arrange
      when(testRocketMQEventSource.testRocketMQMSGSent()).thenReturn(messageChannel);
      when(messageChannel.send(any())).thenReturn(false);
      // Act & Assert
      mockMvc.perform(get("/mqmsg/sent"))
          .andExpect(status().isBadRequest())
          .andExpect(content().contentType("application/json"))
          .andExpect(jsonPath("$.status").value("error"))
          .andExpect(jsonPath("$.data").value(""));
    }
  }

}