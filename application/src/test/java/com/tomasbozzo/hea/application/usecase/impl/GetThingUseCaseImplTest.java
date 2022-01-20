package com.tomasbozzo.hea.application.usecase.impl;

import com.tomasbozzo.hea.application.AbstractApplicationTest;
import com.tomasbozzo.hea.application.usecase.GetThingUseCase;
import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.domain.model.ThingId;
import com.tomasbozzo.hea.domain.repository.ThingRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static com.tomasbozzo.hea.domain.model.ThingFactory.createEmptyThing;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@DisplayName("Get thing use case")
class GetThingUseCaseImplTest extends AbstractApplicationTest {

    @Autowired
    private GetThingUseCase useCase;

    @MockBean
    private ThingRepository thingRepository;

    @Test
    @DisplayName("should return the thing from the thing repository")
    void should_return_all_things_from_the_thing_projection_repository() {
        // Given
        ThingId thingId = new ThingId("the thing id");
        Thing persistedThing = createEmptyThing();
        given(thingRepository.findById(thingId)).willReturn(Optional.of(persistedThing));

        // When
        var result = useCase.execute(new GetThingUseCase.Request(thingId));

        // Then
        assertThat(result).hasValue(persistedThing);
    }

    @Test
    @DisplayName("should return empty if the thing is not found")
    void should_return_empty_if_the_thing_is_not_found() {
        // Given
        ThingId thingId = new ThingId("the thing id");
        given(thingRepository.findById(thingId)).willReturn(Optional.empty());

        // When
        var result = useCase.execute(new GetThingUseCase.Request(thingId));

        // Then
        assertThat(result).isEmpty();
    }

    @Test
    @DisplayName("should throw IllegalArgumentException if request is null")
    void should_throw_IllegalArgumentException_if_request_is_null() {
        // When - Then
        assertThatThrownBy(() -> useCase.execute(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The request must not be null");
    }

    @Nested
    @DisplayName("request")
    class RequestTest {
        @Test
        @DisplayName("should throw IllegalArgumentException if thing id is null")
        void should_throw_IllegalArgumentException_if_request_is_null() {
            // When - Then
            assertThatThrownBy(() -> new GetThingUseCase.Request(null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("The thing id must not be null");
        }
    }
}