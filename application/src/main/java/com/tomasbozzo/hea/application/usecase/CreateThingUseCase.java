package com.tomasbozzo.hea.application.usecase;

import com.tomasbozzo.hea.domain.model.ThingId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

public interface CreateThingUseCase {
    Mono<Response> execute();

    @RequiredArgsConstructor
    @Getter
    class Response {
        private final ThingId thingId;
    }
}
