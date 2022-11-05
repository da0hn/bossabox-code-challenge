package com.gabriel.vuttr.integration;


import com.gabriel.vuttr.core.dtos.CreateToolRequest;
import com.gabriel.vuttr.integration.config.IntegrationTest;
import com.gabriel.vuttr.integration.config.Neo4jContainerSetup;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Set;


@IntegrationTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Neo4jContainerSetup.class)
@DisplayName("Test endpoint POST /tools")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CreateToolEndpointTest extends Neo4jContainerSetup {

  private final WebTestClient webClient;
  private final Neo4jTemplate neo4jTemplate;
  private final Neo4jClient neo4jClient;

  @Autowired
  CreateToolEndpointTest(
    final WebTestClient webClient,
    final Neo4jTemplate neo4jTemplate,
    final Neo4jClient neo4jClient
  ) {
    this.webClient = webClient;
    this.neo4jTemplate = neo4jTemplate;
    this.neo4jClient = neo4jClient;
  }

  @BeforeEach
  void setUp() {
    initDatabase(this.neo4jTemplate, this.neo4jClient);
  }

  @AfterEach
  void tearDown() {
    deleteAll(this.neo4jTemplate, this.neo4jClient);
  }

  @Test
  @DisplayName("Should create an Tool with Tags related")
  void test1() {
    final var request = new CreateToolRequest(
      "title",
      "link",
      "description",
      Set.of("tag1", "tag2", "tag3")
    );
    this.webClient.post()
      .uri("/tools")
      .bodyValue(request)
      .exchange()
      .expectStatus().isCreated()
      .expectBody()
      .jsonPath("$.success").isEqualTo(true)
      .jsonPath("$.data.id").isNumber()
      .jsonPath("$.data.title").isEqualTo("title")
      .jsonPath("$.data.link").isEqualTo("link")
      .jsonPath("$.data.description").isEqualTo("description")
      .jsonPath("$.data.tags").value(Matchers.hasSize(3));
  }

  @Test
  @DisplayName("Should create an Tool with Tags related")
  void test2() {
    final var request = new CreateToolRequest(
      "title",
      "link",
      "description",
      Set.of("tag1", "tag2", "tag3")
    );
    this.webClient.post()
      .uri("/tools")
      .bodyValue(request)
      .exchange()
      .expectStatus().isCreated()
      .expectBody()
      .jsonPath("$.success").isEqualTo(true)
      .jsonPath("$.data.id").isNumber()
      .jsonPath("$.data.title").isEqualTo("title")
      .jsonPath("$.data.link").isEqualTo("link")
      .jsonPath("$.data.description").isEqualTo("description")
      .jsonPath("$.data.tags").value(Matchers.hasSize(3));
  }

  @Test
  @DisplayName("Should not create Tool when field is invalid")
  void test3() {
    final var request = new CreateToolRequest(
      null,
      "link",
      "description",
      Set.of("tag1", "tag2", "tag3")
    );
    this.webClient.post()
      .uri("/tools")
      .bodyValue(request)
      .exchange()
      .expectStatus().isBadRequest()
      .expectBody()
      .jsonPath("$.success").isEqualTo(false)
      .jsonPath("$.data.title").value(Matchers.hasItems(
        "must not be empty",
        "must not be null"
      ));
  }

}
