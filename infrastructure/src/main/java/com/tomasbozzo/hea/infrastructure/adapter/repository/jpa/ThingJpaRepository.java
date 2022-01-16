package com.tomasbozzo.hea.infrastructure.adapter.repository.jpa;

import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.domain.model.ThingId;
import com.tomasbozzo.hea.domain.repository.ThingRepository;
import com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.mapper.ThingMapper;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import static com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.mapper.ThingMapper.toNewJpaEntity;

@RequiredArgsConstructor
public class ThingJpaRepository implements ThingRepository {

    private final ThingSpringJpaRepository repository;

    @Override
    public Mono<Thing> create(Thing thing) {
        return repository.save(toNewJpaEntity(thing))
                .map(ThingMapper::toThing);
    }

    @Override
    public Mono<Thing> findById(ThingId thingId) {
        return repository.findById(thingId.getValue())
                .map(ThingMapper::toThing);
    }
}
