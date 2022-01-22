package com.tomasbozzo.hea.application.usecase.impl;

import static com.tomasbozzo.hea.common.utils.ValidationUtils.validateNotNull;

import com.tomasbozzo.hea.application.usecase.GetThingUseCase;
import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.domain.repository.ThingRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetThingUseCaseImpl implements GetThingUseCase {

  private final ThingRepository thingRepository;

  @Override
  public Optional<Thing> execute(Request request) {
    validateRequest(request);
    return thingRepository.findById(request.getThingId());
  }

  private void validateRequest(Request request) {
    validateNotNull(request, () -> new IllegalArgumentException("The request must not be null"));
  }
}
