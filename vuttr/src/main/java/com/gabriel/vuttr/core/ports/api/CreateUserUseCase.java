package com.gabriel.vuttr.core.ports.api;

import com.gabriel.vuttr.core.domain.Role;
import com.gabriel.vuttr.core.domain.User;
import com.gabriel.vuttr.core.dtos.CreateUserRequest;
import com.gabriel.vuttr.core.dtos.UserCreatedResponse;

import java.util.Optional;
import java.util.Set;

@FunctionalInterface
public interface CreateUserUseCase {

  UserCreatedResponse execute(CreateUserRequest request);

  interface Repository {

    User create(User user);

    Optional<User> maybeGetByEmail(String email);

    Set<Role> findRolesById(Set<Long> roles);


  }

}
