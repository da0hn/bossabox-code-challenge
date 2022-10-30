package com.gabriel.vuttr;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.neo4j.core.Neo4jClient;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@IntegrationTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Neo4jContainerSetup.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ToolEndpointIntegrationTest extends Neo4jContainerSetup {

  private final WebTestClient webClient;
  private final Neo4jTemplate template;
  private final Neo4jClient client;

  @Autowired
  ToolEndpointIntegrationTest(
    final WebTestClient webClient,
    final Neo4jTemplate template,
    final Neo4jClient client
  ) {
    this.webClient = webClient;
    this.template = template;
    this.client = client;
  }

  @BeforeEach
  void setUp() {
    initDatabase(this.template, this.client);
  }

  @AfterEach
  void tearDown() {
    deleteAll(this.template, this.client);
  }

  @Test
  @DisplayName("Should return all data when tag parameter is null")
  void test1() {
    this.webClient.get()
      .uri("/tools")
      .exchange()
      .expectStatus().isEqualTo(HttpStatus.OK)
      .expectBody()
      .jsonPath("$.success").isEqualTo(true)
      .jsonPath("$.data").value(Matchers.hasSize(3));
  }

  @Test
  @DisplayName("Should return only filtered tool by tag parameter")
  void test2() {
    this.webClient.get()
      .uri(builder ->
             builder.path("/tools")
               .queryParam("tag", "node")
               .build()
      )
      .exchange()
      .expectStatus().isEqualTo(HttpStatus.OK)
      .expectBody()
      .jsonPath("$.success").isEqualTo(true)
      .jsonPath("$.data").value(Matchers.hasSize(2));
  }

  @Test
  @DisplayName("Should return empty array when has unknown tag parameter")
  void test3() {
    this.webClient.get()
      .uri(builder ->
             builder.path("/tools")
               .queryParam("tag", "unknown-parameter")
               .build()
      )
      .exchange()
      .expectStatus().isEqualTo(HttpStatus.NOT_FOUND)
      .expectBody()
      .jsonPath("$.success").isEqualTo(true)
      .jsonPath("$.data").value(Matchers.hasSize(0));
  }

  @Test
  @DisplayName("Should return all data when tag parameter is empty string")
  void test4() {
    this.webClient.get()
      .uri(builder ->
             builder.path("/tools")
               .queryParam("tag", "")
               .build()
      )
      .exchange()
      .expectStatus().isEqualTo(HttpStatus.OK)
      .expectBody()
      .jsonPath("$.success").isEqualTo(true)
      .jsonPath("$.data").value(Matchers.hasSize(3));
  }


}
