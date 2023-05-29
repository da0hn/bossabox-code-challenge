package com.gabriel.vuttr.core.dtos;

import java.util.List;

public record ToolUpdatedResponse(
  Long id,
  String title,
  String link,
  String description,
  List<TagUpdatedItemResponse> tags

) {}
