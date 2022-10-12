package com.gabriel.vuttr.application.commons;

import java.util.Collection;

public interface ItemResponse<T> {

  Collection<T> getData();

  boolean getSuccess();


}
