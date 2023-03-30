package com.gabriel.vuttr.application.security.adapters;

import com.gabriel.vuttr.core.domain.DomainException;
import com.gabriel.vuttr.core.ports.api.GetUserByUsernameUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceAdapter implements UserDetailsService {

  private final GetUserByUsernameUseCase getUserByUsernameUseCase;

  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    try {
      final var user = this.getUserByUsernameUseCase.execute(username);
      return UserDetailsAdapter.of(user);
    }
    catch (final DomainException e) {
      throw new UsernameNotFoundException(e.getMessage(), e);
    }
  }

}
