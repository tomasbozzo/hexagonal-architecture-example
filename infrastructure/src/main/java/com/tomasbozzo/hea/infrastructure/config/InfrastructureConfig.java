package com.tomasbozzo.hea.infrastructure.config;

import com.tomasbozzo.hea.application.config.ApplicationConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        ApplicationConfig.class,
        AdapterConfig.class,
})
public class InfrastructureConfig {
}
