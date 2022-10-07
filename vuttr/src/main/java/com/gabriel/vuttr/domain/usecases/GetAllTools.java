package com.gabriel.vuttr.domain.usecases;

import com.gabriel.vuttr.domain.api.IGetAllTools;
import com.gabriel.vuttr.domain.spi.ToolRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllTools implements IGetAllTools {

  private final ToolRepository toolRepository;

  public GetAllTools(final ToolRepository toolRepository) {this.toolRepository = toolRepository;}

  @Override
  public List<ToolItemResponse> execute(final ToolItemParameter parameter) {
    return this.toolRepository.findAllFilteringBy(parameter.tag()).stream()
      .map(ToolItemResponse::of)
      .toList();
  }


}
