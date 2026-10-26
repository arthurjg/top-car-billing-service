package com.topcarservice.coreapi.infra.db;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;
import com.topcarservice.coreapi.domain.usecases.ports.OrcamentoOutputPort;
import com.topcarservice.coreapi.infra.db.mappers.OrcamentoDBMapper;
import com.topcarservice.coreapi.infra.db.repositories.OrcamentoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class OrcamentoOutputDB implements OrcamentoOutputPort {
	
	private final OrcamentoRepository orcamentoRepository;
	
	private final OrcamentoDBMapper ordemServicoDBMapper;

	@Override
	public Optional<OrdemServicoOrcamento> findByCodigoOrdemServico(Long codigo) {		
		return orcamentoRepository.findByCodigoOrdemServico(codigo)
				.map(ordemServicoDBMapper::mapTo);
	}

	

}
