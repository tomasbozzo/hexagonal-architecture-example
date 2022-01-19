package com.tomasbozzo.hea.infrastructure.adapter.transport.event;

import com.tomasbozzo.hea.domain.event.EventPublisher;
import com.tomasbozzo.hea.domain.event.model.Event;

public class MockEventPublisher implements EventPublisher {
    @Override
    public void publish(Event event) {
        // Do nothing
    }
}
