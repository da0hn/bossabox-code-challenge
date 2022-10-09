package com.gabriel.vuttr.core.ports.spi;

import com.gabriel.vuttr.core.ports.api.CreateToolUseCase;
import com.gabriel.vuttr.core.ports.api.DeleteToolUseCase;
import com.gabriel.vuttr.core.ports.api.GetAllToolsUseCase;

public interface ToolRepository extends GetAllToolsUseCase.Repository, CreateToolUseCase.Repository, DeleteToolUseCase.Repository {
}
