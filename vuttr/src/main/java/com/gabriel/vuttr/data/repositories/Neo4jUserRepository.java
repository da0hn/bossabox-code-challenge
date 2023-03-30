package com.gabriel.vuttr.data.repositories;

import com.gabriel.vuttr.core.domain.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Neo4jUserRepository extends Neo4jRepository<User, Long> {

  @Query(
    "MATCH (user:User{email:$email}) " +
    "RETURN COUNT(user) > 1"
  )
  boolean existsByEmail(String email);

  @Query(
    """
    MATCH (user:User{username:$username})-[relation:HAS]->(role:Role)
    WITH user, collect(relation) as roleRelation, collect(role) as roles
    RETURN user, roleRelation, roles
    """
  )
  Optional<User> findByUsername(String username);

}
