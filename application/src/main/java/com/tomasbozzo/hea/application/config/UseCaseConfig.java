package com.tomasbozzo.hea.application.config;

import com.tomasbozzo.hea.application.usecase.impl.CreateThingUseCaseImpl;
import com.tomasbozzo.hea.application.usecase.impl.GetThingUseCaseImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        CreateThingUseCaseImpl.class,
        GetThingUseCaseImpl.class,
})
public class UseCaseConfig {
}
