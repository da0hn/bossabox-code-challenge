package com.gabriel.vuttr.core.usecases;

import com.gabriel.vuttr.core.dtos.UserItemResponse;
import com.gabriel.vuttr.core.ports.api.GetAllUsersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllUsersService implements GetAllUsersUseCase {

  private final Repository repository;

  @Override
  public List<UserItemResponse> execute() {
    return this.repository.findAll().stream()
      .map(UserItemResponse::of)
      .toList();
  }

}
