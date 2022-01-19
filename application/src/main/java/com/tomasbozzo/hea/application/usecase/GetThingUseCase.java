package com.tomasbozzo.hea.application.usecase;

import com.tomasbozzo.hea.domain.model.Thing;
import lombok.Value;

import java.util.Optional;

import static com.tomasbozzo.hea.common.utils.ValidationUtils.validateNotBlank;

public interface GetThingUseCase {
    Optional<Thing> execute(Request request);

    @Value
    class Request {

        String thingId;

        public Request(String thingId) {
            validateThingId(thingId);

            this.thingId = thingId;
        }

        private void validateThingId(String thingId) {
            validateNotBlank(thingId, () -> new IllegalArgumentException("The thingId must not be null"));
        }
    }
}
