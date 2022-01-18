package com.tomasbozzo.hea.application.projection.repository;

import com.tomasbozzo.hea.domain.model.Thing;

import java.util.List;

public interface ThingProjectionRepository {
    List<Thing> findAllThings();
}
