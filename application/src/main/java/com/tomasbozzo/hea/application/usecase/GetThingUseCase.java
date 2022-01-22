package com.tomasbozzo.hea.application.usecase;

import static com.tomasbozzo.hea.common.utils.ValidationUtils.validateNotNull;

import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.domain.model.ThingId;
import java.util.Optional;
import lombok.Getter;

public interface GetThingUseCase {

  Optional<Thing> execute(Request request);

  class Request {

    @Getter
    private final ThingId thingId;

    public Request(ThingId thingId) {
      validateThingId(thingId);

      this.thingId = thingId;
    }

    private void validateThingId(ThingId thingId) {
      validateNotNull(thingId, () -> new IllegalArgumentException("The thing id must not be null"));
    }
  }
}
