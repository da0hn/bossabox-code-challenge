package com.gabriel.vuttr.application;

import com.gabriel.vuttr.core.dtos.CreateToolRequest;
import com.gabriel.vuttr.core.dtos.ToolCreatedResponse;
import com.gabriel.vuttr.core.dtos.ToolItemFilterParameter;
import com.gabriel.vuttr.core.dtos.ToolItemResponse;
import com.gabriel.vuttr.core.ports.api.CreateToolUseCase;
import com.gabriel.vuttr.core.ports.api.GetAllToolsUseCase;
import com.gabriel.vuttr.core.ports.api.DeleteToolUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tools")
public class ToolController {

  private final GetAllToolsUseCase getAllTools;
  private final CreateToolUseCase createTool;
  private final DeleteToolUseCase deleteTool;


  @GetMapping
  public ResponseEntity<List<ToolItemResponse>> findAll(
    @RequestParam(value = "tag", required = false) final String tag
  ) {
    final var response = this.getAllTools.execute(new ToolItemFilterParameter(tag));
    return ResponseEntity.ok(response);
  }

  @PostMapping
  public ResponseEntity<ToolCreatedResponse> create(
    @RequestBody final CreateToolRequest request
  ) {
    final var response = this.createTool.execute(request);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @DeleteMapping("/{toolId}")
  public ResponseEntity<Void> deleteById(@PathVariable("toolId") final Long id) {
    this.deleteTool.execute(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
