package com.tomasbozzo.hea.application.usecase.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.tomasbozzo.hea.application.AbstractApplicationTest;
import com.tomasbozzo.hea.application.projection.repository.ThingProjectionRepository;
import com.tomasbozzo.hea.application.usecase.GetAllThingsUseCase;
import com.tomasbozzo.hea.domain.model.Thing;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

@DisplayName("Get all things use case")
class GetAllThingsUseCaseImplTest extends AbstractApplicationTest {

  @Autowired
  private GetAllThingsUseCase useCase;

  @MockBean
  private ThingProjectionRepository projectionRepository;

  @Test
  @DisplayName("should return all things from the thing projection repository")
  void should_return_all_things_from_the_thing_projection_repository() {
    // Given
    List<Thing> persistedThings = new ArrayList<>();
    given(projectionRepository.findAllThings()).willReturn(persistedThings);

    // When
    var result = useCase.execute();

    // Then
    assertThat(result).isSameAs(persistedThings);
  }
}