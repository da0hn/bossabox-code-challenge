package com.gabriel.vuttr.domain.entities;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Node;

import java.io.Serial;

@Getter
@Node("Tag")
public class Tag extends NodeEntity implements UnmodifiableNodeEntity<Tag> {

  @Serial
  private static final long serialVersionUID = -6759535410416918406L;

  private final String name;

  public Tag(
    final Long id,
    final String name
  ) {
    super(id);
    this.name = name;
  }


  @Override
  public Tag withId(final Long id) {
    return new Tag(id, this.name);
  }

}
