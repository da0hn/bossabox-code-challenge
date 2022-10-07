package com.gabriel.vuttr.domain.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;

import java.io.Serial;
import java.time.LocalDateTime;

@Getter
@Setter
@Node("Tag")
public class Tag extends NodeEntity {

  @Serial
  private static final long serialVersionUID = -6759535410416918406L;

  private String name;

  public Tag(
    final Long id,
    final LocalDateTime createdAt,
    final String name
  ) {
    super(id, createdAt);
    this.name = name;
  }

  public Tag() {
  }


}
