package com.gabriel.vuttr.core.ports.api;

import com.gabriel.vuttr.core.domain.Role;
import com.gabriel.vuttr.core.dtos.UserRolesResponse;

import java.util.List;
import java.util.Set;

@FunctionalInterface
public interface GetAllRolesUseCase {

  List<UserRolesResponse> execute();

  @FunctionalInterface
  interface Repository {

    Set<Role> findAllRoles();

  }
}
