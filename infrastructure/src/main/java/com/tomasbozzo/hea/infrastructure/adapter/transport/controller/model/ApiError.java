package com.tomasbozzo.hea.infrastructure.adapter.transport.controller.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ApiError {

  private final String description;

  @JsonCreator
  public ApiError(@JsonProperty("description") String description) {
    this.description = description;
  }
}
