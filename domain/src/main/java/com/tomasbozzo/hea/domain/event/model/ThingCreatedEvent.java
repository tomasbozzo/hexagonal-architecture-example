package com.tomasbozzo.hea.domain.event.model;

import com.tomasbozzo.hea.domain.model.Thing;
import lombok.Value;

@Value
public class ThingCreatedEvent implements Event {

  Thing thing;
}
