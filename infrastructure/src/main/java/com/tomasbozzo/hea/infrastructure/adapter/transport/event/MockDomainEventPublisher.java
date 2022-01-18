package com.tomasbozzo.hea.infrastructure.adapter.transport.event;

import com.tomasbozzo.hea.domain.event.DomainEventPublisher;
import com.tomasbozzo.hea.domain.event.model.DomainEvent;

public class MockDomainEventPublisher implements DomainEventPublisher {
    @Override
    public void publish(DomainEvent domainEvent) {
        // Do nothing
    }
}
