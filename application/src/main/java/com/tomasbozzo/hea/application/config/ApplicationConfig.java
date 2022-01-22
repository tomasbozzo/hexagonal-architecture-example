package com.tomasbozzo.hea.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
    UseCaseConfig.class,
})
public class ApplicationConfig {

}
