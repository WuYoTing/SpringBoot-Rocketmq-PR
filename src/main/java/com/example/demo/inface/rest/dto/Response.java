package com.example.demo.inface.rest.dto;

import lombok.Getter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Response<T> {

  @Getter
  private String status;

  @Getter
  private T data;
}
