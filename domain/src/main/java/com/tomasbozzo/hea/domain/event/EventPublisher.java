package com.tomasbozzo.hea.domain.event;

import com.tomasbozzo.hea.domain.event.model.Event;

public interface EventPublisher {

  void publish(Event event);
}
