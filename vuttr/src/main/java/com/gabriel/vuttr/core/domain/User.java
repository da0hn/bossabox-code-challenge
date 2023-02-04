package com.gabriel.vuttr.core.domain;

import lombok.Getter;
import org.springframework.data.neo4j.core.schema.Relationship;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serial;
import java.util.Objects;
import java.util.Set;

@Getter
public class User extends NodeEntity<User> implements UnmodifiableNodeEntity<User> {


  @Serial private static final long serialVersionUID = 5030459428429682384L;

  @NotEmpty
  private final String username;
  @NotEmpty
  private final String password;
  @Email
  @NotEmpty
  private final String email;
  @Relationship(type = "HAS")
  private final Set<Role> roles;


  public User(
    final Long id,
    final String username,
    final String password,
    final String email,
    final Set<Role> roles
  ) {
    super(id);
    this.username = username;
    this.password = password;
    this.email = email;
    this.roles = roles;
    this.validateSelf();
  }

  public static User newInstance(
    final String username,
    final String password,
    final String passwordConfirmation,
    final String email,
    final Set<Role> roles
  ) {
    Objects.requireNonNull(password);
    if (!Objects.equals(password, passwordConfirmation)) {
      throw new IllegalStateException("Password don't match");
    }
    return new User(
      null,
      username,
      password,
      email,
      roles
    );
  }


  @Override
  public User withId(final Long id) {
    return new User(
      id,
      this.username,
      this.password,
      this.email,
      this.roles
    );
  }

}
