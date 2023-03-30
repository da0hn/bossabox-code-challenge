package com.gabriel.vuttr.application.web.endpoints.adapters;

import com.gabriel.vuttr.application.commons.Response;
import com.gabriel.vuttr.application.commons.impl.ResponseEntityAdapter;
import com.gabriel.vuttr.core.dtos.UserAuthenticationRequest;
import com.gabriel.vuttr.core.dtos.UserSuccessfullyAuthenticatedResponse;
import com.gabriel.vuttr.core.ports.api.LoginUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserSessionEndpointAdapter {


  private final LoginUserUseCase loginUserUseCase;

  @PostMapping("/login")
  public ResponseEntity<Response<UserSuccessfullyAuthenticatedResponse>> authenticate(@RequestBody @Valid final UserAuthenticationRequest request) {
    final var response = this.loginUserUseCase.execute(request);
    return ResponseEntityAdapter.of(response);
  }

}
