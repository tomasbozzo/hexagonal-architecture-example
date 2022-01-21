package com.tomasbozzo.hea.infrastructure.adapter.transport.controller;

import com.tomasbozzo.hea.application.usecase.GetThingUseCase;
import com.tomasbozzo.hea.domain.model.Thing;
import com.tomasbozzo.hea.domain.model.ThingId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static com.tomasbozzo.hea.domain.model.ThingFactory.createEmptyThing;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ThingControllerTest extends AbstractControllerTest {

    @MockBean
    private GetThingUseCase getThingUseCase;

    @Nested
    @DisplayName("GET /things/{id}")
    class GetThingTest {

        @Captor
        private ArgumentCaptor<GetThingUseCase.Request> requestCaptor;

        @Test
        @DisplayName("should return 404 if GetThingUseCase returns empty")
        void should_return_404_if_GetThingUseCase_returns_empty() throws Exception {
            // Given
            String id = "the thing id";

            given(getThingUseCase.execute(any())).willReturn(Optional.empty());

            // When - Then
            var result = mockMvc.perform(get("/things/{id}", id))
                    .andExpect(status().isNotFound())
                    .andExpect(jsonPath("$.description", equalTo("The thing was not found")))
                    .andReturn();

            assertThat(result).isNotNull();

            verify(getThingUseCase).execute(requestCaptor.capture());
            assertThat(requestCaptor.getValue().getThingId()).isEqualTo(new ThingId(id));
        }

        @Test
        @DisplayName("should return 200 if GetThingUseCase returns a thing")
        void should_return_200_if_GetThingUseCase_returns_a_thing() throws Exception {
            // Given
            Thing persistedThing = createEmptyThing();

            given(getThingUseCase.execute(any())).willReturn(Optional.of(persistedThing));

            // When - Then
            var result = mockMvc.perform(get("/things/{id}", persistedThing.getId().getValue()))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.id", equalTo(persistedThing.getId().getValue())))
                    .andExpect(jsonPath("$.name", equalTo(persistedThing.getName())))
                    .andReturn();

            assertThat(result).isNotNull();

            verify(getThingUseCase).execute(requestCaptor.capture());
            assertThat(requestCaptor.getValue().getThingId()).isEqualTo(persistedThing.getId());
        }
    }
}