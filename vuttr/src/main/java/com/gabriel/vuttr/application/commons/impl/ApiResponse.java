package com.gabriel.vuttr.application.commons.impl;

import com.gabriel.vuttr.application.commons.Response;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ApiResponse<T> implements Response<T> {

  private final T data;
  private final boolean success;

  public static <T> Response<T> of(final T data) {
    return new ApiResponse<>(data, true);
  }

  @Override
  public T getData() {
    return this.data;
  }

  @Override
  public boolean getSuccess() {
    return this.success;
  }

}
