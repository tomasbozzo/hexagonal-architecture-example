package com.tomasbozzo.hea.domain.model;

import static com.tomasbozzo.hea.common.utils.ValidationUtils.validateNotBlank;
import static com.tomasbozzo.hea.common.utils.ValidationUtils.validateNotNull;

import java.util.List;
import lombok.Getter;

public class Thing {

  @Getter
  private ThingId id;

  @Getter
  private String name;

  @Getter
  private List<SubThing> subThings;

  Thing(ThingId id, String name, List<SubThing> subThings) {
    validateId(id);
    validateName(name);
    validateSubThings(subThings);

    this.id = id;
    this.name = name;
    this.subThings = subThings;
  }

  private void validateId(ThingId id) {
    validateNotNull(id, () -> new IllegalArgumentException("The id must not be null"));
  }

  private void validateName(String name) {
    validateNotBlank(name, () -> new IllegalArgumentException("The name must not be blank"));
  }

  private void validateSubThings(List<SubThing> subThings) {
    validateNotNull(subThings,
        () -> new IllegalArgumentException("The sub-thing list must not be null"));
  }
}
