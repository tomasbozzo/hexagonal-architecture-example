package com.tomasbozzo.hea.domain.service.impl;

import static com.tomasbozzo.hea.common.utils.ValidationUtils.validateNotNull;

import com.tomasbozzo.hea.domain.event.EventPublisher;
import com.tomasbozzo.hea.domain.event.model.ThingCreatedEvent;
import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.domain.repository.ThingRepository;
import com.tomasbozzo.hea.domain.service.ThingService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ThingServiceImpl implements ThingService {

  private final ThingRepository repository;
  private final EventPublisher eventPublisher;

  @Override
  public Thing create(Thing thing) {
    validateThing(thing);

    var createdThing = repository.create(thing);
    eventPublisher.publish(new ThingCreatedEvent(createdThing));
    return createdThing;
  }

  private void validateThing(Thing thing) {
    validateNotNull(thing, () -> new IllegalArgumentException("The thing must not be null"));
  }
}
