package com.gabriel.vuttr.data.repositories;

import com.gabriel.vuttr.core.domain.Role;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Neo4jRoleRepository extends Neo4jRepository<Role, Long> {
}
