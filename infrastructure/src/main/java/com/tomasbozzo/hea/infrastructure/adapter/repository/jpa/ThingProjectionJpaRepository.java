package com.tomasbozzo.hea.infrastructure.adapter.repository.jpa;

import com.tomasbozzo.hea.application.projection.repository.ThingProjectionRepository;
import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.mapper.ThingMapper;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ThingProjectionJpaRepository implements ThingProjectionRepository {

  private final ThingSpringJpaRepository repository;

  @Override
  public List<Thing> findAllThings() {
    return StreamSupport.stream(repository.findAll().spliterator(), false)
        .map(ThingMapper::toThing)
        .collect(Collectors.toList());
  }
}
