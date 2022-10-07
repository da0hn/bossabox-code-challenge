package com.gabriel.vuttr.data.repositories.adapters;

import com.gabriel.vuttr.data.repositories.Neo4jToolRepository;
import com.gabriel.vuttr.domain.entities.Tool;
import com.gabriel.vuttr.domain.spi.ToolRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Neo4jToolRepositoryAdapter implements ToolRepository {

  private final Neo4jToolRepository toolRepository;

  public Neo4jToolRepositoryAdapter(final Neo4jToolRepository toolRepository) {
    this.toolRepository = toolRepository;
  }


  @Override
  public List<Tool> findAllFilteringBy(final String tag) {
    return this.toolRepository.findToolsFilteringBy(tag);
  }

}
