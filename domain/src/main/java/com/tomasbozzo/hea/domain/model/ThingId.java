package com.tomasbozzo.hea.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

import static com.tomasbozzo.hea.common.utils.ValidationUtils.validateNotBlank;

@EqualsAndHashCode
public class ThingId {

    @Getter
    private final String value;

    public ThingId() {
        this.value = UUID.randomUUID().toString();
    }

    public ThingId(String value) {
        validateValue(value);

        this.value = value;
    }

    private void validateValue(String value) {
        validateNotBlank(value, () -> new IllegalArgumentException("The id value must not be blank"));
    }
}
