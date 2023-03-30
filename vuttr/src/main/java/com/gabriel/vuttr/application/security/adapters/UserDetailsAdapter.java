package com.gabriel.vuttr.application.security.adapters;

import com.gabriel.vuttr.core.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.util.Collection;

@AllArgsConstructor
public class UserDetailsAdapter implements UserDetails {

  @Serial
  private static final long serialVersionUID = 9169457285471143960L;
  private final User user;

  public static UserDetails of(final User user) {
    return new UserDetailsAdapter(user);
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.user.getRoles().stream()
      .map(role -> (GrantedAuthority) role::getName)
      .toList();
  }

  @Override
  public String getPassword() {
    return this.user.getPassword();
  }

  @Override
  public String getUsername() {
    return this.user.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
