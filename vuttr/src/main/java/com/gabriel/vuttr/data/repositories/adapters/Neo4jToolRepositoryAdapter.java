package com.gabriel.vuttr.data.repositories.adapters;

import com.gabriel.vuttr.core.domain.Tag;
import com.gabriel.vuttr.core.domain.Tool;
import com.gabriel.vuttr.core.ports.spi.ToolRepository;
import com.gabriel.vuttr.data.repositories.Neo4jTagRepository;
import com.gabriel.vuttr.data.repositories.Neo4jToolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class Neo4jToolRepositoryAdapter implements ToolRepository {

  private final Neo4jToolRepository toolRepository;
  private final Neo4jTagRepository tagRepository;


  @Override
  public List<Tool> findAllFilteringBy(final String tag) {
    return this.toolRepository.findToolsFilteringBy(tag);
  }

  @Override
  public Tool create(final Tool tool) {
    return this.toolRepository.save(tool);
  }

  @Override
  public Tag createTag(final Tag tag) {
    return this.tagRepository.save(tag);
  }

  @Override
  public Optional<Tag> maybeGetTag(final String name) {
    return this.tagRepository.findByName(name);
  }

}
