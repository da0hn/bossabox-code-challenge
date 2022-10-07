package com.gabriel.vuttr.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@Node("Tool")
public class Tool extends NodeEntity {

  @Serial
  private static final long serialVersionUID = 4782203338953298977L;

  private String title;
  private String link;
  private String description;
  @JsonIgnoreProperties("tools")
  @Relationship(type = "TAGGED_BY")
  private Set<Tag> tags;

  public Tool(
    final Long id,
    final LocalDateTime createdAt,
    final String title,
    final String link,
    final String description,
    final Set<Tag> tags
  ) {
    super(id, createdAt);
    this.title = title;
    this.link = link;
    this.description = description;
    this.tags = tags;
  }

  public Tool() {
  }


}
