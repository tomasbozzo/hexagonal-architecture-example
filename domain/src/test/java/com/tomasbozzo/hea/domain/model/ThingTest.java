package com.tomasbozzo.hea.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.tomasbozzo.hea.testcommon.source.BlankSource;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class ThingTest {

  public static final String ANY_NAME = "any name";
  private static final List<SubThing> ANY_SUB_THINGS = new ArrayList<>();
  private static final ThingId ANY_THING_ID = new ThingId("any value");

  @Nested
  @DisplayName("new Thing()")
  class ConstructorTest {

    @Test
    @DisplayName("should throw IllegalArgumentException when the thing id is null")
    void should_throw_IllegalArgumentException_when_thing_the_id_is_null() {
      // When
      assertThatThrownBy(() -> new Thing(null, ANY_NAME, ANY_SUB_THINGS))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessage("The id must not be null");
    }

    @DisplayName("should throw IllegalArgumentException when the name is")
    @ParameterizedTest(name = "{0}")
    @BlankSource
    void should_throw_IllegalArgumentException_when_the_name_is_null(String blankString) {
      // When
      assertThatThrownBy(() -> new Thing(ANY_THING_ID, blankString, ANY_SUB_THINGS))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessage("The name must not be blank");
    }

    @Test
    @DisplayName("should throw IllegalArgumentException when the sub-things list is null")
    void should_throw_IllegalArgumentException_when_the_sub_things_list_is_null() {
      // When
      assertThatThrownBy(() -> new Thing(ANY_THING_ID, ANY_NAME, null))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessage("The sub-thing list must not be null");
    }
  }
}