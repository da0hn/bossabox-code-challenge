package com.gabriel.vuttr.application.web.endpoints.adapters;

import com.gabriel.vuttr.application.commons.CollectionResponse;
import com.gabriel.vuttr.application.commons.Response;
import com.gabriel.vuttr.application.commons.impl.ApiResponse;
import com.gabriel.vuttr.application.commons.impl.ResponseEntityAdapter;
import com.gabriel.vuttr.core.dtos.CreateUserRequest;
import com.gabriel.vuttr.core.dtos.UserCreatedResponse;
import com.gabriel.vuttr.core.dtos.UserItemResponse;
import com.gabriel.vuttr.core.dtos.UserRolesResponse;
import com.gabriel.vuttr.core.ports.api.CreateUserUseCase;
import com.gabriel.vuttr.core.ports.api.GetAllRolesUseCase;
import com.gabriel.vuttr.core.ports.api.GetAllUsersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
  private final GetAllRolesUseCase getAllRoles;
  private final GetAllUsersUseCase getAllUsers;

  @PostMapping
  public Response<UserCreatedResponse> create(@Valid @RequestBody final CreateUserRequest request) {
    final var response = this.createUser.execute(request);
    return ApiResponse.of(response);
  }

  @GetMapping
  public ResponseEntity<CollectionResponse<UserItemResponse>> getAllUsers() {
    final var response = this.getAllUsers.execute();
    return ResponseEntityAdapter.items(response);
  }


  @GetMapping("/roles")
  public ResponseEntity<CollectionResponse<UserRolesResponse>> getAllRoles() {
    return ResponseEntityAdapter.items(this.getAllRoles.execute());
  }

}
