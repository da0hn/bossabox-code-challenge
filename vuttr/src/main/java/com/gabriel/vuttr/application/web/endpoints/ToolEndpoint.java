package com.gabriel.vuttr.application.web.endpoints;

import com.gabriel.vuttr.application.commons.CollectionResponse;
import com.gabriel.vuttr.application.commons.Response;
import com.gabriel.vuttr.core.dtos.CreateToolRequest;
import com.gabriel.vuttr.core.dtos.ToolCreatedResponse;
import com.gabriel.vuttr.core.dtos.ToolDetailResponse;
import com.gabriel.vuttr.core.dtos.ToolItemResponse;
import com.gabriel.vuttr.core.dtos.ToolUpdatedResponse;
import com.gabriel.vuttr.core.dtos.UpdateToolRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/tools")
public interface ToolEndpoint {

  @GetMapping
  ResponseEntity<CollectionResponse<ToolItemResponse>> findAll(
    @RequestParam(value = "tag", required = false) String tag
  );

  @GetMapping("/{toolId}")
  ResponseEntity<Response<ToolDetailResponse>> findById(@PathVariable("toolId") Long id);

  @PostMapping
  ResponseEntity<Response<ToolCreatedResponse>> create(
    @RequestBody CreateToolRequest request
  );

  @PutMapping
  ResponseEntity<Response<ToolUpdatedResponse>> update(
    @RequestBody UpdateToolRequest request
  );

  @DeleteMapping("/{toolId}")
  ResponseEntity<Response<Void>> deleteById(@PathVariable("toolId") Long id);

}
