package com.gabriel.vuttr.core.usecases;

import com.gabriel.vuttr.core.domain.Tag;
import com.gabriel.vuttr.core.domain.Tool;
import com.gabriel.vuttr.core.dtos.CreateToolRequest;
import com.gabriel.vuttr.core.dtos.ToolCreatedResponse;
import com.gabriel.vuttr.core.ports.api.ICreateTool;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@AllArgsConstructor
public class CreateTool implements ICreateTool {

  private final Repository repository;

  @Override
  public ToolCreatedResponse execute(final CreateToolRequest request) {
    final var tool = Tool.of(
      request.title(),
      request.link(),
      request.description()
    );

    final var tags = request.tags().stream()
      .map(this::getTagOrCreateIfNotExist)
      .toList();

    tool.addTags(tags);

    final var newTool = this.repository.create(tool);

    return ToolCreatedResponse.of(newTool);
  }

  private Tag getTagOrCreateIfNotExist(final String rawTag) {
    if(!StringUtils.hasText(rawTag)) {
      throw new IllegalArgumentException("Tag must be not null and not empty");
    }
    final var tag = this.repository.maybeGetTag(rawTag);
    if(tag.isEmpty()) {
      final var newTag = Tag.of(rawTag);
      return this.repository.createTag(newTag);
    }
    return tag.get();
  }

}
