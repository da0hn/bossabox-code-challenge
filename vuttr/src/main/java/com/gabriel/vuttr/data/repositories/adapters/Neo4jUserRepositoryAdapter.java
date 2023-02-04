package com.gabriel.vuttr.data.repositories.adapters;

import com.gabriel.vuttr.core.domain.DomainException;
import com.gabriel.vuttr.core.domain.Role;
import com.gabriel.vuttr.core.domain.User;
import com.gabriel.vuttr.core.ports.spi.UserRepository;
import com.gabriel.vuttr.data.repositories.Neo4jRoleRepository;
import com.gabriel.vuttr.data.repositories.Neo4jUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class Neo4jUserRepositoryAdapter implements UserRepository {

  private final Neo4jUserRepository userRepository;
  private final Neo4jRoleRepository roleRepository;


  @Override
  public User create(final User user) {
    return this.userRepository.save(user);
  }

  @Override
  public Set<Role> findRolesById(final Set<Long> roles) {
    return new HashSet<>(this.roleRepository.findAllById(roles));
  }

  public Optional<User> maybeGetByEmail(final String email) {
    return this.userRepository.findByEmail(email);
  }

}
