package com.gabriel.vuttr.core.ports.spi;

import com.gabriel.vuttr.core.domain.User;
import com.gabriel.vuttr.core.ports.api.CreateUserUseCase;
import com.gabriel.vuttr.core.ports.api.GetAllRolesUseCase;
import com.gabriel.vuttr.core.ports.api.GetAllUsersUseCase;

import java.util.Optional;

public interface UserRepository extends CreateUserUseCase.Repository, GetAllRolesUseCase.Repository, GetAllUsersUseCase.Repository {

  Optional<User> findByUsername(String username);

}
