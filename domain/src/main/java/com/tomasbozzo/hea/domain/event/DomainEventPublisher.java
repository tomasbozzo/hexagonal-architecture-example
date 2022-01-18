package com.tomasbozzo.hea.domain.event;

import com.tomasbozzo.hea.domain.event.model.DomainEvent;

public interface DomainEventPublisher {
    void publish(DomainEvent domainEvent);
}
