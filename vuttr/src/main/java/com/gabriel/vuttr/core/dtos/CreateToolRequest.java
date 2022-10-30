package com.gabriel.vuttr.core.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

public record CreateToolRequest(
  @NotEmpty
  @NotNull
  String title,
  @NotEmpty
  @NotNull
  String link,
  @NotEmpty
  @NotNull
  String description,
  @NotEmpty
  @NotNull
  Set<@NotNull String> tags
) {
}
