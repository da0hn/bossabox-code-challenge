package com.gabriel.vuttr.application.commons;

public interface Response<T> {

  T getData();

  boolean getSuccess();

}
