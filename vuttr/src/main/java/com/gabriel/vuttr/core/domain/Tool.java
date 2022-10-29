package com.gabriel.vuttr.core.domain;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serial;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Getter
@Node("Tool")
public class Tool extends NodeEntity<Tool> implements UnmodifiableNodeEntity<Tool> {

  @Serial
  private static final long serialVersionUID = 4782203338953298977L;

  @NotNull
  @NotEmpty
  @NotBlank
  private final String title;
  @NotNull
  @NotEmpty
  @NotBlank
  private final String link;
  @NotEmpty
  @NotNull
  @NotBlank
  private final String description;

  @Relationship(type = "TAGGED_BY")
  private Set<Tag> tags;

  public Tool(
    final Long id,
    final String title,
    final String link,
    final String description,
    final Set<Tag> tags
  ) {
    super(id);
    this.title = title;
    this.link = link;
    this.description = description;
    this.tags = Optional.ofNullable(tags)
      .map(Collections::unmodifiableSet)
      .orElse(null);
    this.validateSelf();
  }

  public static Tool of(
    final String title,
    final String link,
    final String description
  ) {
    return new Tool(
      null,
      title,
      link,
      description,
      null
    );
  }

  private void addTag(final Tag tag) {
    if(this.tags == null) {
      this.tags = new HashSet<>();
    }
    this.tags.add(tag);
  }

  public void addTags(final Iterable<? extends Tag> tags) {
    tags.forEach(this::addTag);
  }


  public List<String> rawTags() {
    return Optional.ofNullable(this.tags)
      .map(t -> t.stream()
        .map(Tag::getName)
        .toList()
      )
      .orElse(new ArrayList<>());
  }

  @Override
  public Tool withId(final Long id) {
    return new Tool(
      id,
      this.title,
      this.link,
      this.description,
      this.tags
    );
  }

}
