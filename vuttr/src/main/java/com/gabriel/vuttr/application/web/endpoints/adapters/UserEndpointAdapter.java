package com.gabriel.vuttr.application.web.endpoints.adapters;

import com.gabriel.vuttr.application.commons.Response;
import com.gabriel.vuttr.application.commons.impl.ApiResponse;
import com.gabriel.vuttr.core.dtos.CreateUserRequest;
import com.gabriel.vuttr.core.dtos.UserCreatedResponse;
import com.gabriel.vuttr.core.ports.api.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserEndpointAdapter {

  private final CreateUserUseCase createUser;

  @PostMapping
  public Response<UserCreatedResponse> create(@Valid @RequestBody final CreateUserRequest request) {
    final var response = this.createUser.execute(request);
    return ApiResponse.of(response);
  }

}
