package com.tomasbozzo.hea.domain.config;

import com.tomasbozzo.hea.domain.service.impl.ThingServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
    ThingServiceImpl.class,
})
public class DomainConfig {

}
