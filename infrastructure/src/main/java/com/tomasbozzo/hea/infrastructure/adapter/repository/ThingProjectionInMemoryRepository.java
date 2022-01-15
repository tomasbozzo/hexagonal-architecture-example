package com.tomasbozzo.hea.infrastructure.adapter.repository;

import com.tomasbozzo.hea.application.projection.repository.ThingProjectionRepository;
import com.tomasbozzo.hea.domain.model.Thing;
import reactor.core.publisher.Flux;

public class ThingProjectionInMemoryRepository implements ThingProjectionRepository {
    @Override
    public Flux<Thing> findAllThings() {
        return Flux.empty();
    }
}
