package com.gabriel.vuttr.data.repositories;

import com.gabriel.vuttr.core.domain.Tag;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Neo4jTagRepository extends Neo4jRepository<Tag, Long> {

  Optional<Tag> findByName(String name);

}
