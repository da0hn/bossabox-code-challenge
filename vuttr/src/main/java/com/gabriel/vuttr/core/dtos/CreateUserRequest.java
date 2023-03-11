package com.gabriel.vuttr.core.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

public record CreateUserRequest(
  @NotBlank
  String username,
  @NotBlank
  String password,
  @NotBlank
  String passwordConfirmation,
  @Email
  @NotBlank
  String email,
  @NotBlank
  Set<Long> roles
) {
}
