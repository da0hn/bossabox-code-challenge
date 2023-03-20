package com.gabriel.vuttr.application.commons.impl;

import com.gabriel.vuttr.application.commons.CollectionResponse;
import lombok.AllArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@AllArgsConstructor
public class ApiCollectionResponse<T> implements CollectionResponse<T> {

  private final Collection<T> data;
  private final boolean success;

  public static <T> CollectionResponse<T> of(final Collection<T> data) {
    return new ApiCollectionResponse<>(
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

  @Override
  public boolean isEmpty() {
    return CollectionUtils.isEmpty(this.data);
  }

}
