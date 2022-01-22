package com.tomasbozzo.hea.infrastructure;

import com.tomasbozzo.hea.infrastructure.config.InfrastructureConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAutoConfiguration
@Import({
    InfrastructureConfig.class,
})
public class HexagonalApplication {

  public static void main(String[] args) {
    SpringApplication.run(HexagonalApplication.class, args);
  }
}
