package com.example.demo.exception;

public class NotFoundException extends RuntimeException {

  private static final long serialVersionUID = 7860691238040502302L;

  public NotFoundException(String message) {
    super(message);
  }
}
