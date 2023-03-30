package com.gabriel.vuttr.core.ports.spi;

public interface UserAuthenticationFacade {

  void authenticate(
    String username,
    String password
  );

  String generateToken(String username);

}
