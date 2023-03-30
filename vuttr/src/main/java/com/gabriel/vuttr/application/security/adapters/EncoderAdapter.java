package com.gabriel.vuttr.application.security.adapters;

import com.gabriel.vuttr.core.ports.spi.Encoder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EncoderAdapter implements Encoder {

  private final PasswordEncoder passwordEncoder;

  @Override
  public String encode(final CharSequence data) {
    return this.passwordEncoder.encode(data);
  }

}
