package com.tomasbozzo.hea.infrastructure.config;

import com.tomasbozzo.hea.infrastructure.adapter.repository.ThingInMemoryRepository;
import com.tomasbozzo.hea.infrastructure.adapter.repository.ThingProjectionInMemoryRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        ThingInMemoryRepository.class,
        ThingProjectionInMemoryRepository.class,
})
public class AdapterConfig {
}
