package com.tomasbozzo.hea.application.usecase;

import com.tomasbozzo.hea.domain.model.Thing;
import reactor.core.publisher.Flux;

public interface GetAllThingsUseCase {
    Response execute();

    record Response(Flux<Thing> things) {
    }
}
