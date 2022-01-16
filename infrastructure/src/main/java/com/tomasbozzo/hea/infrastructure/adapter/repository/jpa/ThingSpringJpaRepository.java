package com.tomasbozzo.hea.infrastructure.adapter.repository.jpa;

import com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.model.ThingJpaEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface ThingSpringJpaRepository extends ReactiveCrudRepository<ThingJpaEntity, String> {
}
