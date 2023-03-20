package com.gabriel.vuttr.application.web.endpoints;

import com.gabriel.vuttr.application.commons.CollectionResponse;
import com.gabriel.vuttr.application.commons.Response;
import com.gabriel.vuttr.core.dtos.CreateToolRequest;
import com.gabriel.vuttr.core.dtos.ToolCreatedResponse;
import com.gabriel.vuttr.core.dtos.ToolItemResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/tools")
public interface ToolEndpoint {

  @GetMapping
  ResponseEntity<CollectionResponse<ToolItemResponse>> findAll(
    @RequestParam(value = "tag", required = false) String tag
  );

  @PostMapping
  ResponseEntity<Response<ToolCreatedResponse>> create(
    @RequestBody CreateToolRequest request
  );

  @DeleteMapping("/{toolId}")
  ResponseEntity<Response<Void>> deleteById(@PathVariable("toolId") Long id);

}
