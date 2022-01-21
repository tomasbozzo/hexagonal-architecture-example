package com.tomasbozzo.hea.infrastructure.config;

import com.tomasbozzo.hea.infrastructure.adapter.transport.controller.exception.ControllerExceptionHandler;
import com.tomasbozzo.hea.infrastructure.adapter.transport.controller.ThingController;
import org.springframework.context.annotation.Import;

@Import({
        ControllerExceptionHandler.class,
        ThingController.class,
})
public class ControllerConfig {
}
