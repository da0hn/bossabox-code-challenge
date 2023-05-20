package com.gabriel.vuttr.core.domain;

import java.io.Serial;

public class EntityNotFoundException extends DomainException {
  @Serial
  private static final long serialVersionUID = -707587352173107958L;

  public EntityNotFoundException() {
  }

  public EntityNotFoundException(final String message) {
    super(message);
  }

  public EntityNotFoundException(final String message, final Object... args) {
    super(message, args);
  }

  public EntityNotFoundException(final String message, final Throwable cause) {
    super(message, cause);
  }

  public EntityNotFoundException(final Throwable cause) {
    super(cause);
  }
}
