package com.tomasbozzo.hea.domain.repository;

import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.domain.model.ThingId;
import reactor.core.publisher.Mono;

public interface ThingRepository {
    Mono<Thing> save(Thing thing);
    Mono<Thing> findById(ThingId thingId);
}
