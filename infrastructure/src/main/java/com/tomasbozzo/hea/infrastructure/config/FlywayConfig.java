package com.tomasbozzo.hea.infrastructure.config;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

@Configuration
public class FlywayConfig {

    @Bean
    public Flyway flyway(
            ResourceLoader resourceLoader,
            @Value("${spring.flyway.url}") String url,
            @Value("${spring.r2dbc.username}") String userName,
            @Value("${spring.r2dbc.password}") String password) {

        FluentConfiguration configuration = new FluentConfiguration(resourceLoader.getClassLoader());
        configuration.dataSource(url, userName, password);
        return configuration.load();
    }

    @Bean
    public FlywayMigrationInitializer flywayInitializer(Flyway flyway,
                                                        ObjectProvider<FlywayMigrationStrategy> migrationStrategy) {
        return new FlywayMigrationInitializer(flyway, migrationStrategy.getIfAvailable());
    }
}
