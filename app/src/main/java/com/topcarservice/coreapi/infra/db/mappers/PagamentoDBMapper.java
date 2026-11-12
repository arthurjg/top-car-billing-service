package com.topcarservice.coreapi.infra.db.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.domain.entities.Pagamento;
import com.topcarservice.coreapi.infra.db.entities.PagamentoDBEntity;

@Component
public class PagamentoDBMapper {
	
	@Autowired
	private ModelMapper objectMapper;

	public PagamentoDBEntity map(Pagamento pagamento) {		
		return objectMapper.map(pagamento, PagamentoDBEntity.class);				
	}	
	
	public Pagamento mapTo(PagamentoDBEntity pagamentoDBEntity) {		
		return objectMapper.map(pagamentoDBEntity, Pagamento.class);			
	}	

}
