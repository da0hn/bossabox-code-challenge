package com.gabriel.vuttr.core.usecases;

import com.gabriel.vuttr.core.dtos.TagItemResponse;
import com.gabriel.vuttr.core.dtos.ToolDetailResponse;
import com.gabriel.vuttr.core.ports.api.GetToolByIdUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GetToolByIdService implements GetToolByIdUseCase {


  private final Repository repository;

  @Override
  public ToolDetailResponse execute(final Long toolId) {

    final var tool = this.repository.findById(toolId);

    return new ToolDetailResponse(
      tool.getId(),
      tool.getTitle(),
      tool.getDescription(),
      tool.getLink(),
      Optional.ofNullable(tool.getTags()).stream()
        .flatMap(Collection::stream)
        .map(tag -> new TagItemResponse(tag.getId(), tag.getName()))
        .sorted(Comparator.comparing(TagItemResponse::name))
        .toList()
    );
  }
}
