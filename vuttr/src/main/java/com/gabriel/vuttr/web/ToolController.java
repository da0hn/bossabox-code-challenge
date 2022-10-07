package com.gabriel.vuttr.web;

import com.gabriel.vuttr.domain.entities.Tool;
import com.gabriel.vuttr.domain.spi.ToolRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tools")
public class ToolController {

  private final ToolRepository toolRepository;

  public ToolController(final ToolRepository toolRepository) {this.toolRepository = toolRepository;}


  @GetMapping
  public ResponseEntity<List<Tool>> findAll() {
    final var tools = this.toolRepository.findAll();
    return ResponseEntity.ok(tools);
  }

}
