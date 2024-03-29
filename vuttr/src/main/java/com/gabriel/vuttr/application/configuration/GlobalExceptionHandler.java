package com.gabriel.vuttr.application.configuration;

import com.gabriel.vuttr.application.commons.ErrorResponse;
import com.gabriel.vuttr.application.commons.impl.ApiErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(ConstraintViolationException.class)
  public ErrorResponse<Map<String, List<String>>> handleValidationExceptions(final ConstraintViolationException ex) {
    final Map<String, List<String>> errors = new HashMap<>();
    ex.getConstraintViolations().forEach(error -> {
      final String fieldName = error.getPropertyPath().toString();
      final String errorMessage = error.getMessage();
      final var values = errors.getOrDefault(fieldName, new ArrayList<>());
      values.add(errorMessage);
      errors.put(fieldName, values);
    });
    return ApiErrorResponse.of(errors, null);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
    final MethodArgumentNotValidException ex,
    final HttpHeaders headers,
    final HttpStatus status,
    final WebRequest request
  ) {
    final Map<String, List<String>> errors = new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(error -> {
      final String fieldName = error.getField();
      final String errorMessage = error.getDefaultMessage();
      final var values = errors.getOrDefault(fieldName, new ArrayList<>());
      values.add(errorMessage);
      errors.put(fieldName, values);
    });
    return ResponseEntity.badRequest().body(ApiErrorResponse.of(errors, null));
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(IllegalArgumentException.class)
  public ErrorResponse<Void> handleIllegalArgumentException(final IllegalArgumentException exception) {
    return ApiErrorResponse.of(exception.getMessage());
  }

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(RuntimeException.class)
  public ErrorResponse<ApiErrorResponse.ApiErrorDetail> handleRuntimeException(final RuntimeException exception) {
    return ApiErrorResponse.of(
      new ApiErrorResponse.ApiErrorDetail(exception.getMessage()),
      "An unexpected error has occurred"
    );
  }

}
