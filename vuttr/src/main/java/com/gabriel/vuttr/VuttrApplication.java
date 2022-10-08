package com.gabriel.vuttr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.config.EnableNeo4jAuditing;

@SpringBootApplication
@EnableNeo4jAuditing
public class VuttrApplication {

  public static void main(final String[] args) {
    SpringApplication.run(VuttrApplication.class, args);
  }

}
