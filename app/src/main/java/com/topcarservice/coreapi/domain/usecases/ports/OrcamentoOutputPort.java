package com.topcarservice.coreapi.domain.usecases.ports;

import java.util.Optional;

import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;

public interface OrcamentoOutputPort {

	Optional<OrdemServicoOrcamento> findByCodigoOrdemServico(Long codigo);

}
