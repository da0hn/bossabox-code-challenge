package com.gabriel.vuttr.core.domain;


import org.springframework.data.annotation.Transient;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
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
