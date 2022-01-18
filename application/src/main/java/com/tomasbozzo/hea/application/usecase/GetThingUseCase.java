package com.tomasbozzo.hea.application.usecase;

import com.tomasbozzo.hea.domain.model.Thing;

import java.util.Optional;

import static com.tomasbozzo.hea.common.utils.ValidationUtils.validateNotBlank;

public interface GetThingUseCase {
    Optional<Thing> execute(Request request);

    record Request(String thingId) {
        public Request {
            validateThingId(thingId);
        }

        private void validateThingId(String thingId) {
            validateNotBlank(thingId, () -> new IllegalArgumentException("The thingId must not be null"));
        }
    }
}
