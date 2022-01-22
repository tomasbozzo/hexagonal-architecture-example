package com.tomasbozzo.hea.domain;

import com.tomasbozzo.hea.domain.config.DomainConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
    DomainConfig.class,
})
public class DomainTestConfig {

}
