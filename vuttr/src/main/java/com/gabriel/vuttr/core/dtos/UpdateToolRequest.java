package com.gabriel.vuttr.core.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public record UpdateToolRequest(
  @NotNull
  Long id,
  @NotBlank
  String title,
  @NotBlank
  String link,
  @NotBlank
  String description,
  List<@NotNull UpdateToolTagItem> tags
) {
}
