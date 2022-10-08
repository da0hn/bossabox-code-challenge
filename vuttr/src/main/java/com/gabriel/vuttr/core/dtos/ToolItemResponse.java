package com.gabriel.vuttr.core.dtos;

import com.gabriel.vuttr.core.domain.Tool;

import java.util.List;

public record ToolItemResponse(
  Long id,
  String title,
  String link,
  String description,
  List<String> tags
) {

  public static ToolItemResponse of(final Tool tool) {
    return new ToolItemResponse(
      tool.getId(),
      tool.getTitle(),
      tool.getLink(),
      tool.getDescription(),
      tool.rawTags()
    );
  }

}
