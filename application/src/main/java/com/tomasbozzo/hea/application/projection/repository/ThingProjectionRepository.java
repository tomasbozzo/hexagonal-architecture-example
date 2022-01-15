package com.tomasbozzo.hea.application.projection.repository;

import com.tomasbozzo.hea.domain.model.Thing;
import reactor.core.publisher.Flux;

public interface ThingProjectionRepository {
    Flux<Thing> findAllThings();
}
