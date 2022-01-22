package com.tomasbozzo.hea.application.usecase.impl;

import static com.tomasbozzo.hea.domain.model.ThingFactory.createEmptyThing;

import com.tomasbozzo.hea.application.usecase.CreateThingUseCase;
import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.domain.service.ThingService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateThingUseCaseImpl implements CreateThingUseCase {

  private final ThingService thingService;

  @Override
  public Response execute() {
    return toResponse(thingService.create(createEmptyThing()));
  }

  private Response toResponse(Thing thing) {
    return new Response(thing.getId());
  }
}
