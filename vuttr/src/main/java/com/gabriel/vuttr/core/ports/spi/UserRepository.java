package com.gabriel.vuttr.core.ports.spi;

import com.gabriel.vuttr.core.ports.api.CreateUserUseCase;
import com.gabriel.vuttr.core.ports.api.GetAllRolesUseCase;
import com.gabriel.vuttr.core.ports.api.GetAllUsersUseCase;

public interface UserRepository extends CreateUserUseCase.Repository, GetAllRolesUseCase.Repository, GetAllUsersUseCase.Repository {
}
