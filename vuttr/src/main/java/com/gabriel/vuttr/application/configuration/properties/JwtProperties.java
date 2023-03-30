package com.gabriel.vuttr.application.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
@ConstructorBinding
@ConfigurationProperties(prefix = "vuttr.jwt")
public record JwtProperties(
  @NotBlank String secret,
  @NotNull @Min(0) Long tokenDurationInHours
) {


}
