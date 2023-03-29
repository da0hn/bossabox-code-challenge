package com.gabriel.vuttr.application.commons;

import java.util.Collection;

public interface CollectionResponse<T> extends Response<Collection<T>> {

  Collection<T> getData();

  boolean getSuccess();

}
