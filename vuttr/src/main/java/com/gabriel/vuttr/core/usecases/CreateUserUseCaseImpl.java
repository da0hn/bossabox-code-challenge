package com.gabriel.vuttr.core.usecases;

import com.gabriel.vuttr.core.domain.Role;
import com.gabriel.vuttr.core.domain.User;
import com.gabriel.vuttr.core.dtos.CreateUserRequest;
import com.gabriel.vuttr.core.dtos.UserCreatedResponse;
import com.gabriel.vuttr.core.ports.api.CreateUserUseCase;
import com.gabriel.vuttr.core.ports.spi.Encoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import java.util.Objects;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {

  private final Repository repository;
  private final Encoder encoder;

  @Override
  public UserCreatedResponse execute(@Valid final CreateUserRequest request) {

    if (request == null) {
      throw new IllegalStateException();
    }

    this.validateUniqueFields(request);
    validatePassword(request);

    final var newUser = User.newInstance(
      request.username(),
      this.encoder.encode(request.password()),
      request.email(),
      this.fetchRoles(request)
    );

    final var createdUser = this.repository.create(newUser);

    return UserCreatedResponse.of(createdUser);
  }

  private void validateUniqueFields(final CreateUserRequest request) {
    // FIXME: validate user with email and username
    final var existsByEmail = this.repository.existsByEmail(request.email());
    if (existsByEmail) {
      throw new IllegalStateException("Cannot create an User with this email");
    }
  }

  private static void validatePassword(final CreateUserRequest request) {
    Objects.requireNonNull(request.password());
    if (!Objects.equals(request.password(), request.passwordConfirmation())) {
      throw new IllegalStateException("Password don't match");
    }
  }

  private Set<Role> fetchRoles(final CreateUserRequest request) {
    final var roles = this.repository.findRolesById(request.roles());

    if (roles.isEmpty()) {
      throw new IllegalStateException("Cannot create a new user without roles.");
    }

    return roles;
  }

}
