package com.tomasbozzo.hea.infrastructure.adapter.transport.controller;

import com.tomasbozzo.hea.application.usecase.CreateThingUseCase;
import com.tomasbozzo.hea.application.usecase.GetAllThingsUseCase;
import com.tomasbozzo.hea.application.usecase.GetThingUseCase;
import com.tomasbozzo.hea.infrastructure.adapter.transport.controller.exception.TestController;
import com.tomasbozzo.hea.infrastructure.config.ControllerConfig;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
    ControllerConfig.class,
    TestController.class,
})
public class ControllerTestConfig {

  @Bean
  CreateThingUseCase createThingUseCase() {
    return Mockito.mock(CreateThingUseCase.class);
  }

  @Bean
  GetThingUseCase getThingUseCase() {
    return Mockito.mock(GetThingUseCase.class);
  }

  @Bean
  GetAllThingsUseCase getAllThingsUseCase() {
    return Mockito.mock(GetAllThingsUseCase.class);
  }
}

