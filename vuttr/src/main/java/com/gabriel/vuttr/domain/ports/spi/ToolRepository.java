package com.gabriel.vuttr.domain.ports.spi;

import com.gabriel.vuttr.domain.entities.Tool;

import java.util.List;

public interface ToolRepository {

  List<Tool> findAllFilteringBy(String tag);

}
