package com.gabriel.vuttr.core.usecases;

import com.gabriel.vuttr.core.dtos.ToolUpdatedResponse;
import com.gabriel.vuttr.core.dtos.UpdateToolRequest;
import com.gabriel.vuttr.core.ports.api.UpdateToolUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateToolUseCaseImpl implements UpdateToolUseCase {

  @Override
  public ToolUpdatedResponse execute(UpdateToolRequest request) {
    return null;
  }

}
