package com.tomasbozzo.hea.testcommon.source;

import static org.junit.jupiter.api.Named.named;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.support.AnnotationConsumer;

public class BlankArgumentsProvider implements ArgumentsProvider, AnnotationConsumer<BlankSource> {

  @Override
  public void accept(BlankSource blankSource) {
    // Do nothing
  }

  @Override
  public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
    return Stream.of(
        Arguments.of(named("null", null)),
        Arguments.of(named("empty string", "")),
        Arguments.of(named("white space", " ")),
        Arguments.of(named("line feed", "\n")),
        Arguments.of(named("carriage return and line feed", "\r\n")),
        Arguments.of(named("tabulation", "\t")));
  }
}
