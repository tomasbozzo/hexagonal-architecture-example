package com.tomasbozzo.hea.domain.event.model;

import com.tomasbozzo.hea.domain.model.ThingId;

public record ThingCreatedEvent(ThingId thingId) implements DomainEvent {

}
