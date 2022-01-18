package com.tomasbozzo.hea.domain.event;

import com.tomasbozzo.hea.domain.event.model.DomainEvent;
import reactor.core.publisher.Mono;

public interface DomainEventPublisher {
    Mono<Void> publish(DomainEvent domainEvent);
}
