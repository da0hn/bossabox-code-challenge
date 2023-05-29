package com.gabriel.vuttr.core.ports.api;

import com.gabriel.vuttr.core.dtos.ToolUpdatedResponse;
import com.gabriel.vuttr.core.dtos.UpdateToolRequest;

public interface UpdateToolUseCase {

  ToolUpdatedResponse execute(UpdateToolRequest request);


  interface Repository {
  }

}
