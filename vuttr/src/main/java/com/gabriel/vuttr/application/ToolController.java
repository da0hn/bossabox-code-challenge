package com.gabriel.vuttr.application;

import com.gabriel.vuttr.core.ports.api.IGetAllTools;
import com.gabriel.vuttr.core.dtos.ToolItemFilterParameter;
import com.gabriel.vuttr.core.dtos.ToolItemResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tools")
public class ToolController {

  private final IGetAllTools getAllTools;


  @GetMapping
  public ResponseEntity<List<ToolItemResponse>> findAll(
    @RequestParam(value = "tag", required = false) final String tag
  ) {
    final var response = this.getAllTools.execute(new ToolItemFilterParameter(tag));
    return ResponseEntity.ok(response);
  }

}
