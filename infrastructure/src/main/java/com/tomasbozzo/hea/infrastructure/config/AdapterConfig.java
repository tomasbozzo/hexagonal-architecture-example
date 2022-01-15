package com.tomasbozzo.hea.infrastructure.config;

import com.tomasbozzo.hea.infrastructure.adapter.repository.ThingInMemoryRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        ThingInMemoryRepository.class,
})
public class AdapterConfig {
}
