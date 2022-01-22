package com.tomasbozzo.hea.infrastructure.adapter.transport.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @GetMapping("/unhandledException")
  public String unhandledException() {
    throw new IllegalArgumentException("the message");
  }

  @GetMapping("/apiException/{message}/{httpStatus}")
  public String apiException(@PathVariable String message, @PathVariable int httpStatus) {
    throw new ApiException(message, HttpStatus.valueOf(httpStatus));
  }

}
