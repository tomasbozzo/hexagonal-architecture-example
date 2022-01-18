package com.tomasbozzo.hea.application.config;

import com.tomasbozzo.hea.domain.config.DomainConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        DomainConfig.class,
        UseCaseConfig.class,
})
public class ApplicationConfig {
}
