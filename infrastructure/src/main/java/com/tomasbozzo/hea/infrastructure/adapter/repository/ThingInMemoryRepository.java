package com.tomasbozzo.hea.infrastructure.adapter.repository;

import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.domain.model.ThingId;
import com.tomasbozzo.hea.domain.repository.ThingRepository;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThingInMemoryRepository implements ThingRepository {

    private final Map<ThingId, Thing> db = new ConcurrentHashMap<>();

    @Override
    public Mono<Thing> save(Thing thing) {
        db.put(thing.getId(), thing);
        return Mono.just(thing);
    }

    @Override
    public Mono<Thing> findById(ThingId thingId) {
        Thing thing = db.get(thingId);

        if (thing != null) {
            return Mono.just(thing);
        } else {
            return Mono.empty();
        }
    }
}
