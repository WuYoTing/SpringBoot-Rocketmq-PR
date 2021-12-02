package com.example.demo.config;

import com.example.demo.exception.ErrorResponse;
import com.example.demo.exception.NotFoundException;
import com.example.demo.exception.QueryException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class RestExceptionHandler {

  /**
   * 處理資源找不到異常
   */
  @ExceptionHandler(NotFoundException.class)
  @ResponseBody
  public ResponseEntity<ErrorResponse> handleNofFound(RuntimeException e) {
    ErrorResponse errorResponse = new ErrorResponse(e.getMessage());
    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
  }

  /**
   * 處理 Query 錯誤
   */
  @ExceptionHandler(QueryException.class)
  @ResponseBody
  public ResponseEntity<ErrorResponse> handleQueryError(RuntimeException e) {
    ErrorResponse errorResponse = new ErrorResponse("Query Error");
    return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * 處理系統異常
   */
  @ExceptionHandler(Exception.class)
  @ResponseBody
  public ResponseEntity<Object> handleException(Exception e) {
    log.error("error", e);
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
