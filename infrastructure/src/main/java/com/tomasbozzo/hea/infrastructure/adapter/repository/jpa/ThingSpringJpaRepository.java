package com.tomasbozzo.hea.infrastructure.adapter.repository.jpa;

import com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.model.ThingJpaEntity;
import org.springframework.data.repository.CrudRepository;


public interface ThingSpringJpaRepository extends CrudRepository<ThingJpaEntity, String> {

}
