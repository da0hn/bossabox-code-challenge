package com.gabriel.vuttr.core.usecases;

import com.gabriel.vuttr.core.ports.api.IGetAllTools;
import com.gabriel.vuttr.core.dtos.ToolItemFilterParameter;
import com.gabriel.vuttr.core.dtos.ToolItemResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllTools implements IGetAllTools {

  private final Repository repository;

  @Override
  public List<ToolItemResponse> execute(final ToolItemFilterParameter parameter) {
    return this.repository.findAllFilteringBy(parameter.tag()).stream()
      .map(ToolItemResponse::of)
      .toList();
  }


}
