package com.tomasbozzo.hea.domain;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = DomainTestConfig.class)
@ExtendWith(SpringExtension.class)
public abstract class AbstractDomainTest {

}
