package com.tomasbozzo.hea.application.usecase.impl;

import com.tomasbozzo.hea.application.projection.repository.ThingProjectionRepository;
import com.tomasbozzo.hea.application.usecase.GetAllThingsUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetAllThingsUseCaseImpl implements GetAllThingsUseCase {

    private final ThingProjectionRepository thingProjectionRepository;

    @Override
    public Response execute() {
        return new Response(thingProjectionRepository.findAllThings());
    }
}
