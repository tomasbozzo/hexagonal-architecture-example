package com.tomasbozzo.hea.infrastructure.adapter.transport.controller.exception;

import com.tomasbozzo.hea.infrastructure.adapter.transport.controller.model.ApiError;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiError> handleApiException(ApiException exception) {
        return new ResponseEntity<>(new ApiError(exception.getMessage()), exception.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleUnhandled(Exception exception) {
        return ResponseEntity
                .internalServerError()
                .body(new ApiError("Internal server error"));
    }
}
