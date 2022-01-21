package com.tomasbozzo.hea.infrastructure.config;

import com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.ThingJpaRepository;
import com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.ThingProjectionJpaRepository;
import com.tomasbozzo.hea.infrastructure.adapter.transport.event.MockEventPublisher;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        ControllerConfig.class,
        MockEventPublisher.class,
        SpringDataConfig.class,
        ThingJpaRepository.class,
        ThingProjectionJpaRepository.class,
})
public class AdapterConfig {
}
