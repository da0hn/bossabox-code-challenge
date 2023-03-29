package com.gabriel.vuttr.application.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Validated
@ConstructorBinding
@ConfigurationProperties(prefix = "vuttr.jwt")
public record JwtProperties(
  @NotBlank String secret
) {


}
