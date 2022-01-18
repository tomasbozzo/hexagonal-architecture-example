package com.tomasbozzo.hea.domain.service.impl;

import com.tomasbozzo.hea.domain.event.DomainEventPublisher;
import com.tomasbozzo.hea.domain.event.model.ThingCreatedEvent;
import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.domain.repository.ThingRepository;
import com.tomasbozzo.hea.domain.service.ThingService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ThingServiceImpl implements ThingService {

    private final ThingRepository repository;
    private final DomainEventPublisher eventPublisher;

    @Override
    public Mono<Thing> create(Thing thing) {
        return repository.create(thing)
                .flatMap(t -> eventPublisher.publish(new ThingCreatedEvent(t.getId())).then(Mono.just(t)));

    }
}
