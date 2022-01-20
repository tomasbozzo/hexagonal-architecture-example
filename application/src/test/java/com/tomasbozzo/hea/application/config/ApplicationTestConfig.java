package com.tomasbozzo.hea.application.config;

import com.tomasbozzo.hea.application.projection.repository.ThingProjectionRepository;
import com.tomasbozzo.hea.domain.event.EventPublisher;
import com.tomasbozzo.hea.domain.repository.ThingRepository;
import com.tomasbozzo.hea.domain.service.ThingService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import({
        ApplicationConfig.class,
})
public class ApplicationTestConfig {

    @Bean
    EventPublisher domainEventPublisher() {
        return Mockito.mock(EventPublisher.class);
    }

    @Bean
    ThingProjectionRepository thingProjectionRepository() {
        return Mockito.mock(ThingProjectionRepository.class);
    }

    @Bean
    ThingRepository thingRepository() {
        return Mockito.mock(ThingRepository.class);
    }

    @Bean
    ThingService thingService() {
        return Mockito.mock(ThingService.class);
    }
}