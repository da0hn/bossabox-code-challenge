package com.gabriel.vuttr.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Node("Tag")
public class Tag extends NodeEntity {

  @Serial
  private static final long serialVersionUID = -6759535410416918406L;


  private String name;
  @Relationship(type = "TAGGED_BY", direction = Relationship.Direction.INCOMING)
  private Set<Tool> tools;

  public Tag(
    final Long id,
    final LocalDateTime createdAt,
    final String name,
    final Set<Tool> tools
  ) {
    super(id, createdAt);
    this.name = name;
    this.tools = tools;
  }

  public Tag() {
  }


}
