package com.gabriel.vuttr.core.ports.api;

import com.gabriel.vuttr.core.domain.Tool;
import com.gabriel.vuttr.core.dtos.ToolItemFilterParameter;
import com.gabriel.vuttr.core.dtos.ToolItemResponse;

import java.util.List;

@FunctionalInterface
public interface GetAllToolsUseCase {

  List<ToolItemResponse> execute(ToolItemFilterParameter parameter);

  @FunctionalInterface
  interface Repository {
      List<Tool> findAllFilteringBy(String tag);
  }
}
