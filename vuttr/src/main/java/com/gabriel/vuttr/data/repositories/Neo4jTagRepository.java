package com.gabriel.vuttr.data.repositories;

import com.gabriel.vuttr.domain.entities.Tag;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Neo4jTagRepository extends Neo4jRepository<Tag, Long> {
}
