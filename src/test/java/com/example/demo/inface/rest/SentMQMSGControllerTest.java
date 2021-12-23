package com.example.demo.inface.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.example.demo.infra.broker.TestRocketMQEventSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
class SentMQMSGControllerTest {

  private MockMvc mockMvc;

  @Mock
  private TestRocketMQEventSource testRocketMQEventSource;

  @Autowired
  public SentMQMSGControllerTest(TestRocketMQEventSource testRocketMQEventSource, MockMvc mockMvc) {
    this.testRocketMQEventSource = testRocketMQEventSource;
    this.mockMvc = mockMvc;
  }

  @Test
  @DisplayName("sentMSG_should_send_message")
  public void sentMSG_should_send_message() throws Exception {
    // Arrange
    // Act
    // when(testRocketMQEventSource.testRocketMQMSGSent().send(any())).thenReturn(true);
    // Assert
    mockMvc.perform(get("/mqmsg/sent"))
        .andExpect(status().isOk());
  }


}