package com.gabriel.vuttr.core.domain;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.data.annotation.Transient;

import java.util.Set;

public abstract class SelfValidating<T> {

  @Transient
  private final Validator validator;

  protected SelfValidating() {
    final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    this.validator = factory.getValidator();
  }

  @SuppressWarnings("unchecked")
  protected void validateSelf() {
    final Set<ConstraintViolation<T>> violations = this.validator.validate((T) this);
    if(!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
  }

}
