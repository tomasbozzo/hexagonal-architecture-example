package com.tomasbozzo.hea.infrastructure.config;

import com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.ThingJpaRepository;
import com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.ThingProjectionJpaRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        ThingJpaRepository.class,
        ThingProjectionJpaRepository.class,
})
public class AdapterConfig {
}
