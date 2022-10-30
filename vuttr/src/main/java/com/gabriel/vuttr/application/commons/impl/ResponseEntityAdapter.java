package com.gabriel.vuttr.application.commons.impl;

import com.gabriel.vuttr.application.commons.ItemResponse;
import com.gabriel.vuttr.application.commons.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public class ResponseEntityAdapter<T> extends ResponseEntity<T> {

  public ResponseEntityAdapter(
    final T body,
    final HttpStatus status
  ) {
    super(body, status);
  }

  public static <T> ResponseEntity<ItemResponse<T>> items(final Collection<T> item) {
    final var status = item.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK;
    return new ResponseEntityAdapter<>(ApiItemResponse.of(item), status);
  }

  public static <T> ResponseEntity<Response<T>> of(final T data) {
    return new ResponseEntityAdapter<>(ApiResponse.of(data), HttpStatus.OK);
  }

  public static <T> ResponseEntity<Response<T>> of(
    final T data,
    final HttpStatus status
  ) {
    return new ResponseEntityAdapter<>(ApiResponse.of(data), status);
  }


  public static ResponseEntity<Response<Void>> empty() {
    return new ResponseEntityAdapter<>(ApiResponse.of(null), HttpStatus.OK);
  }

}
