package com.gabriel.vuttr.data.repositories;

import com.gabriel.vuttr.core.domain.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Neo4jUserRepository extends Neo4jRepository<User, Long> {

  @Query(
    "MATCH (user:User{email:$email}) " +
    "RETURN COUNT(user) > 1"
  )
  boolean existsByEmail(String email);

}
