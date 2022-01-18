package com.tomasbozzo.hea.application.usecase.impl;

import com.tomasbozzo.hea.application.projection.repository.ThingProjectionRepository;
import com.tomasbozzo.hea.application.usecase.GetAllThingsUseCase;
import com.tomasbozzo.hea.domain.model.Thing;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllThingsUseCaseImpl implements GetAllThingsUseCase {

    private final ThingProjectionRepository thingProjectionRepository;

    @Override
    public List<Thing> execute() {
        return thingProjectionRepository.findAllThings();
    }
}
