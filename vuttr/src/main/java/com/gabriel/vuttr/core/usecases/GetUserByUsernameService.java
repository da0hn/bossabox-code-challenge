package com.gabriel.vuttr.core.usecases;

import com.gabriel.vuttr.core.domain.DomainException;
import com.gabriel.vuttr.core.domain.User;
import com.gabriel.vuttr.core.ports.api.GetUserByUsernameUseCase;
import com.gabriel.vuttr.core.ports.spi.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class GetUserByUsernameService implements GetUserByUsernameUseCase {

  private final UserRepository repository;


  @Override
  public User execute(final String username) throws DomainException {
    return this.repository.findByUsername(username)
      .orElseThrow(() -> new DomainException("User not found"));
  }

}
