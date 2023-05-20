package com.gabriel.vuttr.core.dtos;

import java.util.List;

public record ToolDetailResponse(
  Long id,
  String title,
  String description,
  String link,
  List<TagItemResponse> tags
) {


}
