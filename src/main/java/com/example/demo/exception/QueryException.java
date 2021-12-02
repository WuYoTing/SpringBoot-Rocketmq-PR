package com.example.demo.exception;

public class QueryException extends RuntimeException {

  private static final long serialVersionUID = -5003401001062052190L;

  public QueryException(String message) {
    super(message);
  }
}
