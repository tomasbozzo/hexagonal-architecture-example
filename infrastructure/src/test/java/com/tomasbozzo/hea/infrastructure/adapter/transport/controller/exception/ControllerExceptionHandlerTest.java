package com.tomasbozzo.hea.infrastructure.adapter.transport.controller.exception;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.tomasbozzo.hea.infrastructure.adapter.transport.controller.AbstractControllerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

@DisplayName("The controller exception handler")
class ControllerExceptionHandlerTest extends AbstractControllerTest {

  @Test
  @DisplayName("should return 500 when an unhandled exception is thrown")
  void should_return_500_when_unhandled_exception_is_thrown() throws Exception {
    // When - Then
    var result = mockMvc.perform(get("/unhandledException"))
        .andExpect(status().isInternalServerError())
        .andExpect(jsonPath("$.description", equalTo("Internal server error")))
        .andReturn();

    assertThat(result).isNotNull();
  }

  @Test
  @DisplayName("should return the specified status and message when an ApiException is thrown")
  void should_return_the_specified_status_and_message_when_an_ApiException_is_thrown()
      throws Exception {
    // Given
    var message = "the message";
    var httpStatus = HttpStatus.ALREADY_REPORTED.value();

    // When - Then
    var result = mockMvc.perform(get("/apiException/{message}/{httpStatus}", message, httpStatus))
        .andExpect(status().is(httpStatus))
        .andExpect(jsonPath("$.description", equalTo(message)))
        .andReturn();

    assertThat(result).isNotNull();
  }
}
