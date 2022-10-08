package com.gabriel.vuttr.core.ports.api;

import org.springframework.transaction.annotation.Transactional;

@FunctionalInterface
public interface IDeleteTool {


  @Transactional
  void execute(final Long id);


  interface Repository {

    void deleteById(final Long id);

  }


}
