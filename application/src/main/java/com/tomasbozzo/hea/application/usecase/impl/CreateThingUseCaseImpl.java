package com.tomasbozzo.hea.application.usecase.impl;

import com.tomasbozzo.hea.application.usecase.CreateThingUseCase;
import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.domain.repository.ThingRepository;
import lombok.RequiredArgsConstructor;

import static com.tomasbozzo.hea.domain.model.ThingFactory.createEmptyThing;

@RequiredArgsConstructor
public class CreateThingUseCaseImpl implements CreateThingUseCase {

    private final ThingRepository thingRepository;

    @Override
    public Response execute() {
        return toResponse(thingRepository.create(createEmptyThing()));
    }

    private Response toResponse(Thing thing) {
        return new Response(thing.getId());
    }
}
