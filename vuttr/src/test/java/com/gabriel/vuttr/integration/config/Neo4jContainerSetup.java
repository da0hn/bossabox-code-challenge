package com.gabriel.vuttr.integration.config;

import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jDataAutoConfiguration;
import org.springframework.boot.autoconfigure.neo4j.Neo4jAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.testcontainers.containers.Neo4jContainer;

import java.util.Objects;

@TestConfiguration
@ImportAutoConfiguration({
  Neo4jAutoConfiguration.class,
  Neo4jDataAutoConfiguration.class
})
@EnableTransactionManagement
@EnableNeo4jRepositories(
  considerNestedRepositories = true,
  basePackages = "com.gabriel.vuttr"
)
public abstract class Neo4jContainerSetup {

  private static final Neo4jContainer<?> neo4jContainer = new Neo4jContainer<>("neo4j:4.4")
    .withoutAuthentication()
    .withReuse(false);


  @DynamicPropertySource
  static void neo4jProperties(final DynamicPropertyRegistry registry) {

    neo4jContainer.start();

    registry.add("spring.neo4j.uri", neo4jContainer::getBoltUrl);
    registry.add("spring.neo4j.authentication.name", () -> "neo4j");
    registry.add("spring.neo4j.authentication.password", neo4jContainer::getAdminPassword);

  }


  public static void initDatabase(
    final Neo4jTemplate template,
    final Neo4jClient client
  ) {
    Objects.requireNonNull(template);
    Objects.requireNonNull(client);

    client.query(
      """
      CREATE (notion:Tool {
        title:       'Notion',
        link:        'https://notion.so',
        description: 'All in one tool to organize teams and ideas. Write, plan, collaborate, and get organized.'
      })

      // tags for notion
      CREATE (organization:Tag {name: 'organization'})
      CREATE (planning:Tag {name: 'planning'})
      CREATE (collaboration:Tag {name: 'collaboration'})
      CREATE (writing:Tag {name: 'writing'})
      CREATE (calendar:Tag {name: 'calendar'})

      // create relations
      CREATE (organization)<-[:TAGGED_BY]-(notion)
      CREATE (planning)<-[:TAGGED_BY]-(notion)
      CREATE (collaboration)<-[:TAGGED_BY]-(notion)
      CREATE (writing)<-[:TAGGED_BY]-(notion)
      CREATE (calendar)<-[:TAGGED_BY]-(notion)

      CREATE (jsonserver:Tool {
        title:       'json-server',
        link:        'https://github.com/typicode/json-server',
        description: 'Fake REST API based on a json schema. Useful for mocking and creating APIs for front-end devs to consume in coding challenges.'
      })
      // tags for json-server
      CREATE (api:Tag {name: 'api'})
      CREATE (json:Tag {name: 'json'})
      CREATE (schema:Tag {name: 'schema'})
      CREATE (github:Tag {name: 'github'})
      CREATE (rest:Tag {name: 'rest'})
      CREATE (node:Tag {name: 'node'})

      // create relations
      CREATE (api)<-[:TAGGED_BY]-(jsonserver)
      CREATE (json)<-[:TAGGED_BY]-(jsonserver)
      CREATE (schema)<-[:TAGGED_BY]-(jsonserver)
      CREATE (github)<-[:TAGGED_BY]-(jsonserver)
      CREATE (rest)<-[:TAGGED_BY]-(jsonserver)
      CREATE (node)<-[:TAGGED_BY]-(jsonserver)

      CREATE (fastify:Tool {
        title:       'fastify',
        link:        'https://www.fastify.io/',
        description: 'Extremely fast and simple, low-overhead web framework for NodeJS. Supports HTTP2.'
      })

      // tags for fastify
      CREATE (web:Tag {name: 'web'})
      CREATE (framework:Tag {name: 'framework'})
      CREATE (http2:Tag {name: 'http2'})
      CREATE (https:Tag {name: 'https'})
      CREATE (localhost:Tag {name: 'localhost'})

      // create relations
      CREATE (web)<-[:TAGGED_BY]-(fastify)
      CREATE (framework)<-[:TAGGED_BY]-(fastify)
      CREATE (http2)<-[:TAGGED_BY]-(fastify)
      CREATE (https)<-[:TAGGED_BY]-(fastify)
      CREATE (localhost)<-[:TAGGED_BY]-(fastify)
      CREATE (node)<-[:TAGGED_BY]-(fastify)

      """).run();
  }

  public static void deleteAll(
    final Neo4jTemplate template,
    final Neo4jClient client
  ) {
    Objects.requireNonNull(template);
    Objects.requireNonNull(client);

    client.query(
      """
      MATCH (n) DETACH DELETE n
      """
    ).run();
  }


}
