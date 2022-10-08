package com.gabriel.vuttr.application.configuration;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ConstraintViolationException.class)
  public Map<String, String> handleValidationExceptions(final ConstraintViolationException ex) {
    final Map<String, String> errors = new HashMap<>();
    ex.getConstraintViolations().forEach(error -> {
      final String fieldName = error.getPropertyPath().toString();
      final String errorMessage = error.getMessage();
      errors.put(fieldName, errorMessage);
    });
    return errors;
  }

}
