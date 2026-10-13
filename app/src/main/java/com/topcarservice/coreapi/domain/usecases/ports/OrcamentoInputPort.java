package com.topcarservice.coreapi.domain.usecases.ports;

import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;

public interface OrcamentoInputPort {

	OrdemServicoOrcamento save(OrdemServicoOrcamento ordemServicoOrcamento);

}
