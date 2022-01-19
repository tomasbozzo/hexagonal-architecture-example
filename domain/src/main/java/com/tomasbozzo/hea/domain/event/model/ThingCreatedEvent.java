package com.tomasbozzo.hea.domain.event.model;

import com.tomasbozzo.hea.domain.model.ThingId;
import lombok.Value;

@Value
public class ThingCreatedEvent implements DomainEvent {
    ThingId thingId;
}
