package com.tomasbozzo.hea.infrastructure.adapter.transport.controller.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

  @Getter
  private final HttpStatus httpStatus;

  public ApiException(String message, HttpStatus httpStatus) {
    super(message);
    this.httpStatus = httpStatus;
  }
}
