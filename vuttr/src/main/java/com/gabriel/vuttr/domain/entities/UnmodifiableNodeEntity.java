package com.gabriel.vuttr.domain.entities;

@FunctionalInterface
public interface UnmodifiableNodeEntity<T extends NodeEntity> {

  T withId(Long id);

}
