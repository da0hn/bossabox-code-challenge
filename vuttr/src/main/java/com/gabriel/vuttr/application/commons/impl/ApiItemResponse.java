package com.gabriel.vuttr.application.commons.impl;

import com.gabriel.vuttr.application.commons.ItemResponse;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@AllArgsConstructor
public class ApiItemResponse<T> implements ItemResponse<T> {

  private final Collection<T> data;
  private final boolean success;

  public static <T> ItemResponse<T> of(final Collection<T> data) {
    return new ApiItemResponse<>(
      data,
      true
    );
  }

  @Override
  public Collection<T> getData() {
    return Optional.ofNullable(this.data)
      .map(Collections::unmodifiableCollection)
      .orElseGet(ArrayList::new);
  }

  @Override
  public boolean getSuccess() {
    return this.success;
  }

}
