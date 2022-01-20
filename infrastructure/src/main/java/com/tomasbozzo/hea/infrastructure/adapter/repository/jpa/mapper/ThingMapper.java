package com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.mapper;

import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.domain.model.ThingFactory;
import com.tomasbozzo.hea.domain.model.ThingId;
import com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.model.ThingJpaEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ThingMapper {

    public static Thing toThing(ThingJpaEntity entity) {
        return ThingFactory.createThing(
                new ThingId(entity.getId()),
                entity.getName(),
                new ArrayList<>()
        );
    }

    public static ThingJpaEntity toNewJpaEntity(Thing thing) {
        var result = new ThingJpaEntity();

        result.setId(thing.getId().getValue());
        result.setName(thing.getName());

        result.setAsNew();

        return result;
    }
}
