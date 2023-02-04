package com.gabriel.vuttr.core.domain;

import java.io.Serial;
import java.text.MessageFormat;

public class DomainException extends RuntimeException {

  @Serial private static final long serialVersionUID = 4768758917494329411L;


  public DomainException() {
    super();
  }

  public DomainException(final String message) {
    super(message);
  }

  public DomainException(
    final String message,
    final Object... args
  ) {
    super(MessageFormat.format(message, args));
  }


  public DomainException(
    final String message,
    final Throwable cause
  ) {
    super(message, cause);
  }

  public DomainException(final Throwable cause) {
    super(cause);
  }

}
