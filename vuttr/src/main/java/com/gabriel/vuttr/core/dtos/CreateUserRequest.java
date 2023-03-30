package com.gabriel.vuttr.core.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
  @NotEmpty
  Set<Long> roles
) {
}
