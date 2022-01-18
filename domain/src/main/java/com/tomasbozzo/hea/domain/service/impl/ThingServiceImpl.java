package com.tomasbozzo.hea.domain.service.impl;

import com.tomasbozzo.hea.domain.event.DomainEventPublisher;
import com.tomasbozzo.hea.domain.event.model.ThingCreatedEvent;
import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.domain.repository.ThingRepository;
import com.tomasbozzo.hea.domain.service.ThingService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ThingServiceImpl implements ThingService {

    private final ThingRepository repository;
    private final DomainEventPublisher eventPublisher;

    @Override
    public Thing create(Thing thing) {
        var createdThing = repository.create(thing);
        eventPublisher.publish(new ThingCreatedEvent(createdThing.getId()));
        return createdThing;
    }
}
