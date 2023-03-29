package com.gabriel.vuttr.core.dtos;

import com.gabriel.vuttr.core.domain.Role;
import com.gabriel.vuttr.core.domain.User;

import java.util.Set;
import java.util.stream.Collectors;

public record UserItemResponse(
  Long idUser,
  String username,
  Set<UserItemRoleResponse> roles
) {

  public static UserItemResponse of(final User user) {
    return new UserItemResponse(
      user.getId(),
      user.getUsername(),
      user.getRoles().stream()
        .map(UserItemRoleResponse::of)
        .collect(Collectors.toSet())
    );
  }


  public record UserItemRoleResponse(
    Long id,
    String name
  ) {

    public static UserItemRoleResponse of(final Role role) {
      return new UserItemRoleResponse(
        role.getId(),
        role.getName()
      );
    }

  }

}
