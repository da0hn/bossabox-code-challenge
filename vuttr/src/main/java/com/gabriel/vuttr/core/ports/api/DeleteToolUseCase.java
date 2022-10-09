package com.gabriel.vuttr.core.ports.api;

import org.springframework.transaction.annotation.Transactional;

@FunctionalInterface
public interface DeleteToolUseCase {


  @Transactional
  void execute(final Long id);


  @FunctionalInterface
  interface Repository {

    void deleteById(final Long id);

  }


}
