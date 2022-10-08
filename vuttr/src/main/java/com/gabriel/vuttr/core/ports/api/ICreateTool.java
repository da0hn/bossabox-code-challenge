package com.gabriel.vuttr.core.ports.api;

import com.gabriel.vuttr.core.domain.Tag;
import com.gabriel.vuttr.core.domain.Tool;
import com.gabriel.vuttr.core.dtos.CreateToolRequest;
import com.gabriel.vuttr.core.dtos.ToolCreatedResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ICreateTool {

  @Transactional
  ToolCreatedResponse execute(CreateToolRequest request);

  interface Repository {

    Tool create(Tool tool);

    Tag createTag(Tag tag);

    Optional<Tag> maybeGetTag(String name);

  }

}
