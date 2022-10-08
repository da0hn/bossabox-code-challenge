package com.gabriel.vuttr.core.usecases;

import com.gabriel.vuttr.core.ports.api.IGetAllTools;
import com.gabriel.vuttr.core.dtos.ToolItemFilterParameter;
import com.gabriel.vuttr.core.dtos.ToolItemResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllTools implements IGetAllTools {

  private final Repository repository;

  public GetAllTools(final Repository repository) {this.repository = repository;}

  @Override
  public List<ToolItemResponse> execute(final ToolItemFilterParameter parameter) {
    return this.repository.findAllFilteringBy(parameter.tag()).stream()
      .map(ToolItemResponse::of)
      .toList();
  }


}
