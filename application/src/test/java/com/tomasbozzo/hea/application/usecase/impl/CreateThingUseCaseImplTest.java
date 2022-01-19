package com.tomasbozzo.hea.application.usecase.impl;

import com.tomasbozzo.hea.application.AbstractApplicationTest;
import com.tomasbozzo.hea.application.config.ApplicationTestConfig;
import com.tomasbozzo.hea.application.usecase.CreateThingUseCase;
import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.domain.model.ThingFactory;
import com.tomasbozzo.hea.domain.model.ThingId;
import com.tomasbozzo.hea.domain.service.ThingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@DisplayName("Create thing use case")
class CreateThingUseCaseImplTest extends AbstractApplicationTest {

    @Autowired
    private CreateThingUseCase useCase;

    @MockBean
    private ThingService thingService;

    @Captor
    private ArgumentCaptor<Thing> thingCaptor;

    @Test
    @DisplayName("should return the event created by the domain service")
    void should_return_the_event_created_by_the_domain_service() {
        // Given
        Thing persistedThing = createThing();
        given(thingService.create(any())).willReturn(persistedThing);

        // When
        var result = useCase.execute();

        // Then
        assertThat(result.getThingId()).isEqualTo(persistedThing.getId());

        verify(thingService).create(thingCaptor.capture());
        assertThat(thingCaptor.getValue().getId()).isNotNull();
        assertThat(thingCaptor.getValue().getName()).isEqualTo("an empty thing");
        assertThat(thingCaptor.getValue().getSubThings()).isEmpty();
    }

    private Thing createThing() {
        return ThingFactory.createThing(new ThingId("id"), "the name", emptyList());
    }
}