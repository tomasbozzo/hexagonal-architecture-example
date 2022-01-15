package com.tomasbozzo.hea.application.usecase.impl;

import com.tomasbozzo.hea.application.usecase.GetThingUseCase;
import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.domain.model.ThingId;
import com.tomasbozzo.hea.domain.repository.ThingRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class GetThingUseCaseImpl implements GetThingUseCase {

    private final ThingRepository thingRepository;

    @Override
    public Mono<Response> execute(Request request) {
        return thingRepository.findById(new ThingId(request.id()))
                .map(this::toResponse);
    }

    private Response toResponse(Thing thing) {
        return new Response(thing);
    }
}
