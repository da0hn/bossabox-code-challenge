package com.gabriel.vuttr.core.ports.api;

import com.gabriel.vuttr.core.domain.DomainException;
import com.gabriel.vuttr.core.domain.User;

import java.util.Optional;

@FunctionalInterface
public interface GetUserByUsernameUseCase {

  User execute(String username) throws DomainException;

  @FunctionalInterface
  interface Repository {

    Optional<User> findByUsername(String username);

  }


}
