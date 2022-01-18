package com.tomasbozzo.hea.domain.service;

import com.tomasbozzo.hea.domain.model.Thing;
import reactor.core.publisher.Mono;

public interface ThingService {
    Mono<Thing> create(Thing thing);
}
