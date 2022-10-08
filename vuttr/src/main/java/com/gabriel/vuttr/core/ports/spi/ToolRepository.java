package com.gabriel.vuttr.core.ports.spi;

import com.gabriel.vuttr.core.ports.api.ICreateTool;
import com.gabriel.vuttr.core.ports.api.IDeleteTool;
import com.gabriel.vuttr.core.ports.api.IGetAllTools;

public interface ToolRepository extends IGetAllTools.Repository, ICreateTool.Repository, IDeleteTool.Repository {
}
