package com.gabriel.vuttr.core.usecases;

import com.gabriel.vuttr.core.ports.api.IDeleteTool;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
public class DeleteTool implements IDeleteTool {


  private final Repository repository;


  @Override
  public void execute(final Long id) {
    Objects.requireNonNull(id, "Tool id must be not null");
    this.repository.deleteById(id);
  }

}
