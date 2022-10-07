package com.gabriel.vuttr.domain.api;

import com.gabriel.vuttr.domain.usecases.ToolItemParameter;
import com.gabriel.vuttr.domain.usecases.ToolItemResponse;

import java.util.List;

public interface IGetAllTools {

  List<ToolItemResponse> execute(ToolItemParameter parameter);

}
