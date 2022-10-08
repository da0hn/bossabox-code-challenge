package com.gabriel.vuttr.core.dtos;

import java.util.Set;

public record CreateToolRequest(
  String title,
  String link,
  String description,
  Set<String> tags
) {
}
