package com.gabriel.vuttr.core.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Node;

import java.io.Serial;

@Getter
@Node("Tag")
public class Tag extends NodeEntity<Tag> implements UnmodifiableNodeEntity<Tag> {

  @Serial
  private static final long serialVersionUID = -6759535410416918406L;

  @NotNull
  @NotEmpty
  private final String name;

  public Tag(
    final Long id,
    final String name
  ) {
    super(id);
    this.name = name;
    this.validateSelf();
  }


  @Override
  public Tag withId(final Long id) {
    return new Tag(id, this.name);
  }

}
