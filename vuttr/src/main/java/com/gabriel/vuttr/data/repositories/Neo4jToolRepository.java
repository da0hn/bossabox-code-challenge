package com.gabriel.vuttr.data.repositories;

import com.gabriel.vuttr.domain.entities.Tool;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Neo4jToolRepository extends Neo4jRepository<Tool, Long> {
}
