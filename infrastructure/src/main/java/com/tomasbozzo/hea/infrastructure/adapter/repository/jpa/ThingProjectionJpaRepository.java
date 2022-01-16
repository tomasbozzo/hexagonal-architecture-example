package com.tomasbozzo.hea.infrastructure.adapter.repository.jpa;

import com.tomasbozzo.hea.application.projection.repository.ThingProjectionRepository;
import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.mapper.ThingMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ThingProjectionJpaRepository implements ThingProjectionRepository {

    private final ThingSpringJpaRepository repository;

    @Override
    public Flux<Thing> findAllThings() {
        return repository.findAll()
                .map(ThingMapper::toThing);
    }
}
