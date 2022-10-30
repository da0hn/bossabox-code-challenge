package com.gabriel.vuttr.application.web.endpoints.adapters;

import com.gabriel.vuttr.application.commons.ItemResponse;
import com.gabriel.vuttr.application.commons.Response;
import com.gabriel.vuttr.application.commons.impl.ResponseEntityAdapter;
import com.gabriel.vuttr.application.web.endpoints.ToolEndpoint;
import com.gabriel.vuttr.core.dtos.CreateToolRequest;
import com.gabriel.vuttr.core.dtos.ToolCreatedResponse;
import com.gabriel.vuttr.core.dtos.ToolItemFilterParameter;
import com.gabriel.vuttr.core.dtos.ToolItemResponse;
import com.gabriel.vuttr.core.ports.api.CreateToolUseCase;
import com.gabriel.vuttr.core.ports.api.DeleteToolUseCase;
import com.gabriel.vuttr.core.ports.api.GetAllToolsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class ToolEndpointAdapter implements ToolEndpoint {

  private final GetAllToolsUseCase getAllTools;
  private final CreateToolUseCase createTool;
  private final DeleteToolUseCase deleteTool;


  @Override
  public ResponseEntity<ItemResponse<ToolItemResponse>> findAll(final String tag) {
    final var response = this.getAllTools.execute(new ToolItemFilterParameter(tag));
    return ResponseEntityAdapter.items(response);
  }

  @Override
  public ResponseEntity<Response<ToolCreatedResponse>> create(@Valid final CreateToolRequest request) {
    final var response = this.createTool.execute(request);
    return ResponseEntityAdapter.of(response, HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<Response<Void>> deleteById(final Long id) {
    this.deleteTool.execute(id);
    return ResponseEntityAdapter.empty();
  }

}
