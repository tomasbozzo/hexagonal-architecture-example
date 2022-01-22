package com.tomasbozzo.hea.common.utils;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValidationUtils {

  private static <T, E extends Exception> void validate(T t, Predicate<T> predicate,
      Supplier<E> exceptionSupplier) throws E {
    if (predicate.negate().test(t)) {
      throw exceptionSupplier.get();
    }
  }

  public static <E extends Exception> void validateNotBlank(CharSequence charSequence,
      Supplier<E> exceptionSupplier) throws E {
    validate(charSequence, StringUtils::isNotBlank, exceptionSupplier);
  }

  public static <E extends Exception> void validateNotNull(Object object,
      Supplier<E> exceptionSupplier) throws E {
    validate(object, Objects::nonNull, exceptionSupplier);
  }
}
