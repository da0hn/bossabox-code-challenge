package com.gabriel.vuttr.application;

import com.gabriel.vuttr.core.dtos.CreateToolRequest;
import com.gabriel.vuttr.core.dtos.ToolCreatedResponse;
import com.gabriel.vuttr.core.dtos.ToolItemFilterParameter;
import com.gabriel.vuttr.core.dtos.ToolItemResponse;
import com.gabriel.vuttr.core.ports.api.ICreateTool;
import com.gabriel.vuttr.core.ports.api.IGetAllTools;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

  private final IGetAllTools getAllTools;
  private final ICreateTool createTool;


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
    return ResponseEntity.ok(response);
  }


}
