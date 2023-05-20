package com.gabriel.vuttr.core.usecases;

import com.gabriel.vuttr.core.dtos.UserAuthenticationRequest;
import com.gabriel.vuttr.core.dtos.UserSuccessfullyAuthenticatedResponse;
import com.gabriel.vuttr.core.ports.api.LoginUserUseCase;
import com.gabriel.vuttr.core.ports.spi.UserAuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LoginUserUseCaseImpl implements LoginUserUseCase {

  private final UserAuthenticationFacade userAuthenticationFacade;

  @Override
  public UserSuccessfullyAuthenticatedResponse execute(final UserAuthenticationRequest request) {
    this.userAuthenticationFacade.authenticate(request.login(), request.password());
    final var generatedToken = this.userAuthenticationFacade.generateToken(request.login());
    return new UserSuccessfullyAuthenticatedResponse(generatedToken);
  }

}
