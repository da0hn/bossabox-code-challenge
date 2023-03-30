package com.gabriel.vuttr.core.ports.spi;

@FunctionalInterface
public interface Encoder {

  String encode(CharSequence data);

}
