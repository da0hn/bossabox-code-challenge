package com.gabriel.vuttr.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
public abstract class NodeEntity implements Serializable {

  @Serial private static final long serialVersionUID = -6436068998233172605L;
  @Id
  @GeneratedValue
  protected final Long id;
  @CreatedDate
  protected LocalDateTime createdAt;

  protected NodeEntity(final Long id) {
    this.id = id;
  }


  @Override
  public int hashCode() {
    return Objects.hash(this.id);
  }

  @Override
  public boolean equals(final Object o) {
    if(this == o) return true;
    if(o == null || this.getClass() != o.getClass()) return false;
    final NodeEntity that = (NodeEntity) o;
    return this.id.equals(that.id);
  }

}
