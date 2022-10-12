package com.gabriel.vuttr.application.commons;

import java.time.LocalDateTime;

public interface ErrorResponse<T> extends Response<T> {

  String getMessage();

  LocalDateTime getTime();

}
