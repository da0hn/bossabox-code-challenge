package com.gabriel.vuttr.data.repositories.adapters;

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
  public boolean existsByEmail(final String email) {
    return this.userRepository.existsByEmail(email);
  }

  @Override
  public Set<Role> findRolesById(final Set<Long> rolesId) {
    return new HashSet<>(this.roleRepository.findAllById(rolesId));
  }

  @Override
  public Set<Role> findAllRoles() {
    return new HashSet<>(this.roleRepository.findAll());
  }

  @Override
  public Set<User> findAll() {
    return new HashSet<>(this.userRepository.findAll());
  }

  @Override
  public Optional<User> findByUsername(final String username) {
    return this.userRepository.findByUsername(username);
  }

}
