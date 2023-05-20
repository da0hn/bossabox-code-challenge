package com.gabriel.vuttr.core.usecases;

import com.gabriel.vuttr.core.dtos.UserRolesResponse;
import com.gabriel.vuttr.core.ports.api.GetAllRolesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllRolesUseCaseImpl implements GetAllRolesUseCase {

  private final Repository repository;

  @Override
  public List<UserRolesResponse> execute() {
    return this.repository.findAllRoles().stream()
      .map(role -> new UserRolesResponse(role.getId(), role.getName()))
      .toList();
  }

}
