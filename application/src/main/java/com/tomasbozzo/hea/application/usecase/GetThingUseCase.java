package com.tomasbozzo.hea.application.usecase;

import com.tomasbozzo.hea.domain.model.Thing;
import reactor.core.publisher.Mono;

import static com.tomasbozzo.hea.common.utils.ValidationUtils.validateNotBlank;

public interface GetThingUseCase {
    Mono<Response> execute(Request request);

    record Request(String id) {
        public Request {
            validateId(id);
        }

        private void validateId(String id) {
            validateNotBlank(id, () -> new IllegalArgumentException("The id must not be null"));
        }
    }

    record Response(Thing thing) {}
}
