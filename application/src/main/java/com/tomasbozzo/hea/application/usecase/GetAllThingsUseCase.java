package com.tomasbozzo.hea.application.usecase;

import com.tomasbozzo.hea.domain.model.Thing;
import java.util.List;

public interface GetAllThingsUseCase {

  List<Thing> execute();
}
