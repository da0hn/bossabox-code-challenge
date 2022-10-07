package com.gabriel.vuttr.web;

import com.gabriel.vuttr.domain.api.IGetAllTools;
import com.gabriel.vuttr.domain.usecases.ToolItemResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tools")
public class ToolController {

  private final IGetAllTools getAllTools;


  @GetMapping
  public ResponseEntity<List<ToolItemResponse>> findAll() {
    final var response = this.getAllTools.execute(null);
    return ResponseEntity.ok(response);
  }

}
