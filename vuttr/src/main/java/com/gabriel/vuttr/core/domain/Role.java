package com.gabriel.vuttr.core.domain;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class Role extends NodeEntity<Role> implements UnmodifiableNodeEntity<Role> {

  @NotEmpty
  private final String name;

  public Role(
    final Long id,
    final String name
  ) {
    super(id);
    this.name = name;
    this.validateSelf();
  }

  @Override
  public Role withId(final Long id) {
    return new Role(id, this.name);
  }

}
