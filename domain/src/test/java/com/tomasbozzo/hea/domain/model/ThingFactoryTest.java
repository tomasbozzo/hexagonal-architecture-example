package com.tomasbozzo.hea.domain.model;

import static com.tomasbozzo.hea.domain.model.ThingFactory.createEmptyThing;
import static com.tomasbozzo.hea.domain.model.ThingFactory.createThing;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ThingFactoryTest {

  @Nested
  @DisplayName("createEmptyThing()")
  class CreateEmptyThingTest {

    private Thing result;

    @BeforeEach
    void setUp() {
      // When
      result = createEmptyThing();
    }

    @Test
    @DisplayName("should return a thing with name 'an empty thing'")
    void should_return_a_thing_with_name_an_empty_thing() {
      // Then
      assertThat(result.getName()).isEqualTo("an empty thing");
    }

    @Test
    @DisplayName("should return a thing with a not empty id")
    void should_return_a_thing_with_a_not_empty_id() {
      // Then
      assertThat(result.getId()).isNotNull();
    }

    @Test
    @DisplayName("should return a thing without sub-things")
    void should_return_a_thing_without_sub_things() {
      // Then
      assertThat(result.getSubThings())
          .isNotNull()
          .isEmpty();
    }
  }

  @Nested
  @DisplayName("createThing()")
  class CreateThingTest {

    @Test
    @DisplayName("should create a thing with the specified parameters")
    void should_create_a_thing_with_the_specified_parameters() {
      // Given
      var thingId = new ThingId("the value");
      var thingName = "the thing name";
      var subThings = List.of(new SubThing());

      // When
      var result = createThing(thingId, thingName, subThings);

      // Then
      assertThat(result.getId()).isEqualTo(thingId);
      assertThat(result.getName()).isEqualTo(thingName);
      assertThat(result.getSubThings()).isEqualTo(subThings);
    }
  }
}