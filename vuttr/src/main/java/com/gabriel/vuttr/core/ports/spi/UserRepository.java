package com.gabriel.vuttr.core.ports.spi;

import com.gabriel.vuttr.core.ports.api.CreateUserUseCase;
import com.gabriel.vuttr.core.ports.api.GetAllRolesUseCase;

public interface UserRepository extends CreateUserUseCase.Repository, GetAllRolesUseCase.Repository {
}
