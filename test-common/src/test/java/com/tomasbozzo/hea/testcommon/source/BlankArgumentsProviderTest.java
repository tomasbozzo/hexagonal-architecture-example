package com.tomasbozzo.hea.testcommon.source;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.mockito.Mockito;

class BlankArgumentsProviderTest {

  @Test
  @DisplayName("should provide blank strings")
  void name() {
    // Given
    var provider = new BlankArgumentsProvider();
    var blankSource = Mockito.mock(BlankSource.class);
    var excentionContext = Mockito.mock(ExtensionContext.class);

    // When
    provider.accept(blankSource);
    var result = provider.provideArguments(excentionContext);

    // Then
    assertThat(result)
        .isNotEmpty()
        .satisfies(arguments -> {

          assertThat(arguments.get(0).get()[0])
              .asInstanceOf(type(Named.class))
              .satisfies(named -> {
                assertThat(named.getName()).isEqualTo("null");
                assertThat(named.getPayload()).isNull();
              });

          assertThat(arguments.get(1).get()[0])
              .asInstanceOf(type(Named.class))
              .satisfies(named -> {
                assertThat(named.getName()).isEqualTo("empty string");
                assertThat(named.getPayload()).isEqualTo("");
              });

          assertThat(arguments.get(2).get()[0])
              .asInstanceOf(type(Named.class))
              .satisfies(named -> {
                assertThat(named.getName()).isEqualTo("white space");
                assertThat(named.getPayload()).isEqualTo(" ");
              });

          assertThat(arguments.get(3).get()[0])
              .asInstanceOf(type(Named.class))
              .satisfies(named -> {
                assertThat(named.getName()).isEqualTo("line feed");
                assertThat(named.getPayload()).isEqualTo("\n");
              });

          assertThat(arguments.get(4).get()[0])
              .asInstanceOf(type(Named.class))
              .satisfies(named -> {
                assertThat(named.getName()).isEqualTo("carriage return and line feed");
                assertThat(named.getPayload()).isEqualTo("\r\n");
              });

          assertThat(arguments.get(5).get()[0])
              .asInstanceOf(type(Named.class))
              .satisfies(named -> {
                assertThat(named.getName()).isEqualTo("tabulation");
                assertThat(named.getPayload()).isEqualTo("\t");
              });
        });
  }
}