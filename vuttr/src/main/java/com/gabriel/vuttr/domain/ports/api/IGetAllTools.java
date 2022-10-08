package com.gabriel.vuttr.domain.ports.api;

import com.gabriel.vuttr.domain.usecases.ToolItemParameter;
import com.gabriel.vuttr.domain.usecases.ToolItemResponse;

import java.util.List;

public interface IGetAllTools {

  List<ToolItemResponse> execute(ToolItemParameter parameter);

}
