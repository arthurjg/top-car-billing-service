package com.topcarservice.coreapi.adapters.controllers.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.adapters.controllers.dto.PagamentoDTO;
import com.topcarservice.coreapi.domain.entities.Pagamento;

@Component
public class PagamentoMapper {
	
	@Autowired
	private ModelMapper objectMapper;	

	public PagamentoDTO map(Pagamento pagamento) {			
		
		return objectMapper.map(pagamento, PagamentoDTO.class);
	}		

}
