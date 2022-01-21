package com.tomasbozzo.hea.domain.service.impl;

import com.tomasbozzo.hea.domain.event.EventPublisher;
import com.tomasbozzo.hea.domain.event.model.Event;
import com.tomasbozzo.hea.domain.event.model.ThingCreatedEvent;
import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.domain.repository.ThingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.tomasbozzo.hea.domain.model.ThingFactory.createEmptyThing;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.InstanceOfAssertFactories.type;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ThingServiceImplTest {

    @InjectMocks
    private ThingServiceImpl service;

    @Mock
    private ThingRepository repository;

    @Mock
    private EventPublisher eventPublisher;

    @Captor
    private ArgumentCaptor<Event> eventCaptor;

    @Nested
    @DisplayName("create()")
    class CreateTest {

        @Test
        @DisplayName("should throw IllegalArgumentException if thing is null")
        void should_throw_IllegalArgumentException_if_thing_is_null() {
            // When - Then
            assertThatThrownBy(() -> service.create(null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("The thing must not be null");
        }

        @Nested
        @DisplayName("given a valid thing")
        class ValidThingTest {

            private Thing persistedThing;
            private Thing result;

            @BeforeEach
            void setUp() {
                // Given
                Thing thing = createEmptyThing();

                persistedThing = createEmptyThing();
                when(repository.create(thing)).thenReturn(persistedThing);

                // When
                result = service.create(thing);
            }

            @Test
            @DisplayName("should return the new persisted thing")
            void should_return_the_new_persisted_thing() {
                // Then
                assertThat(result).isSameAs(persistedThing);
            }

            @Test
            @DisplayName("should publish a ThingCreatedEvent")
            void should_publish_a_ThingCreatedEvent() {
                // Then
                verify(eventPublisher).publish(eventCaptor.capture());
                assertThat(eventCaptor.getValue())
                        .asInstanceOf(type(ThingCreatedEvent.class))
                        .satisfies(thingCreatedEvent -> assertThat(thingCreatedEvent.getThing()).isSameAs(persistedThing));
            }

        }
    }
}