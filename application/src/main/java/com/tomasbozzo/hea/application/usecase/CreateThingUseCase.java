package com.tomasbozzo.hea.application.usecase;

import com.tomasbozzo.hea.domain.model.ThingId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public interface CreateThingUseCase {

  Response execute();

  @RequiredArgsConstructor
  @Getter
  class Response {

    private final ThingId thingId;
  }
}
