package com.tomasbozzo.hea.infrastructure.adapter.repository.jpa;

import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.domain.model.ThingId;
import com.tomasbozzo.hea.domain.repository.ThingRepository;
import com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.mapper.ThingMapper;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

import static com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.mapper.ThingMapper.toNewJpaEntity;
import static com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.mapper.ThingMapper.toThing;

@RequiredArgsConstructor
public class ThingJpaRepository implements ThingRepository {

    private final ThingSpringJpaRepository repository;

    @Override
    public Thing create(Thing thing) {
        return toThing(repository.save(toNewJpaEntity(thing)));
    }

    @Override
    public Optional<Thing> findById(ThingId thingId) {
        return repository.findById(thingId.getValue())
                .map(ThingMapper::toThing);
    }
}
