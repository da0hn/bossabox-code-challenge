package com.gabriel.vuttr.core.ports.api;

import com.gabriel.vuttr.core.domain.Tool;
import com.gabriel.vuttr.core.dtos.ToolDetailResponse;

@FunctionalInterface
public interface GetToolByIdUseCase {

  ToolDetailResponse execute(Long toolId);

  @FunctionalInterface
  interface Repository {
    Tool findById(Long toolId);

  }

}
