package com.gabriel.vuttr.core.ports.api;

import com.gabriel.vuttr.core.domain.User;
import com.gabriel.vuttr.core.dtos.UserItemResponse;

import java.util.List;
import java.util.Set;

@FunctionalInterface
public interface GetAllUsersUseCase {

  List<UserItemResponse> execute();

  @FunctionalInterface
  interface Repository {

    Set<User> findAll();

  }

}
