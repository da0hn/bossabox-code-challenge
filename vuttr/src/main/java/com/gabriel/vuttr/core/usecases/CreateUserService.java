package com.gabriel.vuttr.core.usecases;

import com.gabriel.vuttr.core.domain.Role;
import com.gabriel.vuttr.core.domain.User;
import com.gabriel.vuttr.core.dtos.CreateUserRequest;
import com.gabriel.vuttr.core.dtos.UserCreatedResponse;
import com.gabriel.vuttr.core.ports.api.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {


  private final Repository repository;


  @Override
  public UserCreatedResponse execute(@Valid final CreateUserRequest request) {

    if (request == null) {
      throw new IllegalStateException();
    }

    final var maybeUser = this.repository.maybeGetByEmail(request.email());
    if (maybeUser.isPresent()) {
      throw new IllegalStateException("User already exists!");
    }

    final var newUser = User.newInstance(
      request.username(),
      request.password(),
      request.passwordConfirmation(),
      request.email(),
      this.fetchRoles(request)
    );

    final var createdUser = this.repository.create(newUser);

    return UserCreatedResponse.of(createdUser);
  }

  private Set<Role> fetchRoles(final CreateUserRequest request) {
    final var roles = this.repository.findRolesById(request.roles());

    if (roles.isEmpty()) {
      throw new IllegalStateException("Cannot create a new user without roles.");
    }

    return roles;
  }

}
