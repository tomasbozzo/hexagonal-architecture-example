package com.tomasbozzo.hea.infrastructure.adapter.transport.event;

import com.tomasbozzo.hea.domain.event.DomainEventPublisher;
import com.tomasbozzo.hea.domain.event.model.DomainEvent;
import reactor.core.publisher.Mono;

public class MockDomainEventPublisher implements DomainEventPublisher {
    @Override
    public Mono<Void> publish(DomainEvent domainEvent) {
        return Mono.empty();
    }
}
