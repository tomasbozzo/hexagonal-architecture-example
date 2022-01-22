package com.tomasbozzo.hea.infrastructure.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories({
    "com.tomasbozzo.hea.infrastructure.adapter.repository.jpa"
})
@EntityScan({
    "com.tomasbozzo.hea.infrastructure.adapter.repository.jpa.model"
})
public class SpringDataConfig {

}
