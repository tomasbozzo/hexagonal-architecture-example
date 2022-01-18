package com.tomasbozzo.hea.infrastructure.config;

import com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.ThingJpaRepository;
import com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.ThingProjectionJpaRepository;
import com.tomasbozzo.hea.infrastructure.adapter.transport.event.MockDomainEventPublisher;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        MockDomainEventPublisher.class,
        ThingJpaRepository.class,
        ThingProjectionJpaRepository.class,
})
public class AdapterConfig {
}
