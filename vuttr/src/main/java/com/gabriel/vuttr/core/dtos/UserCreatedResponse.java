package com.gabriel.vuttr.core.dtos;

import com.gabriel.vuttr.core.domain.User;

public record UserCreatedResponse(
  Long id
) {

  public static UserCreatedResponse of(final User user) {
    return new UserCreatedResponse(user.getId());
  }

}
