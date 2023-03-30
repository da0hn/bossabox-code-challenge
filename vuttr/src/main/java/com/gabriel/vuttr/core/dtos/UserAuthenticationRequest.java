package com.gabriel.vuttr.core.dtos;

import javax.validation.constraints.NotBlank;

public record UserAuthenticationRequest(
  @NotBlank String login,
  @NotBlank String password
) {
}
