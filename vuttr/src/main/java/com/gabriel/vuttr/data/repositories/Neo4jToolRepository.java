package com.gabriel.vuttr.data.repositories;

import com.gabriel.vuttr.domain.entities.Tool;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Neo4jToolRepository extends Neo4jRepository<Tool, Long> {

  @Query(
    "MATCH (tool:Tool)-[relation:TAGGED_BY]->(tag:Tag) " +
    "WITH tool, collect(tag) AS tags, collect(relation) AS taggedBy " +
    "WHERE any(t IN tags WHERE t.name = $tag) OR $tag IS NULL " +
    "RETURN tool, tags, taggedBy "
  )
  List<Tool> findToolsFilteringBy(String tag);

}
