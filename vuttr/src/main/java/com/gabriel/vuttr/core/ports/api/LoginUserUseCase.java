package com.gabriel.vuttr.core.ports.api;

import com.gabriel.vuttr.core.dtos.UserAuthenticationRequest;
import com.gabriel.vuttr.core.dtos.UserSuccessfullyAuthenticatedResponse;

@FunctionalInterface
public interface LoginUserUseCase {

  UserSuccessfullyAuthenticatedResponse execute(UserAuthenticationRequest request);

}
