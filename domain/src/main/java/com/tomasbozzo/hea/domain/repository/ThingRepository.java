package com.tomasbozzo.hea.domain.repository;

import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.domain.model.ThingId;
import java.util.Optional;

public interface ThingRepository {

  Thing create(Thing thing);

  Optional<Thing> findById(ThingId thingId);
}
