package com.gabriel.vuttr.core.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

public record CreateUserRequest(
  @NotEmpty
  String username,
  @NotEmpty
  String password,
  @NotEmpty
  String passwordConfirmation,
  @Email
  @NotEmpty
  String email,
  @NotEmpty
  Set<Long> roles
) {
}
