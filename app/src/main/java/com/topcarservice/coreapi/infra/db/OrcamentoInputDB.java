package com.topcarservice.coreapi.infra.db;

import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;
import com.topcarservice.coreapi.domain.usecases.ports.OrcamentoInputPort;
import com.topcarservice.coreapi.infra.db.mappers.OrcamentoDBMapper;
import com.topcarservice.coreapi.infra.db.repositories.OrcamentoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class OrcamentoInputDB implements OrcamentoInputPort {
	
	private final OrcamentoRepository orcamentoRepository;
	
	private final OrcamentoDBMapper ordemServicoDBMapper;

	@Override
	public OrdemServicoOrcamento save(OrdemServicoOrcamento ordemServicoOrcamento) {
		
		var ordemServicoDB = ordemServicoDBMapper.map(ordemServicoOrcamento);		
		var ordemServicoDBSaved = orcamentoRepository.save(ordemServicoDB);
		
		return ordemServicoOrcamento;
		
	}	

}
