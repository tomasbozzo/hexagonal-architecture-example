package com.tomasbozzo.hea.infrastructure.config;

import com.tomasbozzo.hea.application.config.ApplicationConfig;
import com.tomasbozzo.hea.domain.config.DomainConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
    ApplicationConfig.class,
    AdapterConfig.class,
    DomainConfig.class,
})
public class InfrastructureConfig {

}
