package com.topcarservice.coreapi.infra.db.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;
import com.topcarservice.coreapi.infra.db.entities.OrcamentoDBEntity;

@Component
public class OrcamentoDBMapper {
	
	@Autowired
	private ModelMapper objectMapper;

	public OrcamentoDBEntity map(OrdemServicoOrcamento ordemServicoOrcamento) {		
		return OrcamentoDBEntity.builder()
				.codigoOrdemServico(ordemServicoOrcamento.getCodigoOrdemServico())
				.dataAbertura(ordemServicoOrcamento.getDataOrcamento())
				.valorTotal(ordemServicoOrcamento.getValorTotal())				
				.build();				
	}	
	
	public OrdemServicoOrcamento mapTo(OrcamentoDBEntity orcamentoDBEntity) {		
		return objectMapper.map(orcamentoDBEntity, OrdemServicoOrcamento.class);			
	}	

}
