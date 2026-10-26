package com.topcarservice.coreapi.adapters.gateways.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.domain.entities.Pagamento;
import com.topcarservice.coreapi.infra.http.client.dto.PagamentoDTO;

@Component("pagamentoGatewayMapper")
public class PagamentoMapper {
	
	@Autowired
	private ModelMapper objectMapper;	

	public PagamentoDTO map(Pagamento pagamento) {			
		
		return objectMapper.map(pagamento, PagamentoDTO.class);
	}		

}
