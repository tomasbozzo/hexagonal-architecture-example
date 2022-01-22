package com.tomasbozzo.hea.application;

import com.tomasbozzo.hea.application.config.ApplicationTestConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = ApplicationTestConfig.class)
@ExtendWith(SpringExtension.class)
public abstract class AbstractApplicationTest {

}
