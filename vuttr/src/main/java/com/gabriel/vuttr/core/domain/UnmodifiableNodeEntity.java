package com.gabriel.vuttr.core.domain;

@FunctionalInterface
public interface UnmodifiableNodeEntity<T extends NodeEntity> {

  T withId(Long id);

}
