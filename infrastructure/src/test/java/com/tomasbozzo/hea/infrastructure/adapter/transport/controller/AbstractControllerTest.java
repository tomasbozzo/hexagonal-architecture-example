package com.tomasbozzo.hea.infrastructure.adapter.transport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
@ContextConfiguration(classes = {
    ControllerTestConfig.class,
})
public abstract class AbstractControllerTest {

  @Autowired
  protected MockMvc mockMvc;
}
