package com.topcarservice.coreapi.infra.db;

import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.domain.entities.Pagamento;
import com.topcarservice.coreapi.domain.usecases.ports.PagamentoInputPort;
import com.topcarservice.coreapi.infra.db.mappers.PagamentoDBMapper;
import com.topcarservice.coreapi.infra.db.repositories.PagamentoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PagamentoInputDB implements PagamentoInputPort {
	
	private final PagamentoRepository pagamentoRepository;
	
	private final PagamentoDBMapper pagamentoDBMapper;

	@Override
	public Pagamento save(Pagamento pagamento) {
		
		var pagamentoDBEntity = pagamentoDBMapper.map(pagamento);		
		pagamentoDBEntity = pagamentoRepository.save(pagamentoDBEntity);
		
		return pagamentoDBMapper.mapTo(pagamentoDBEntity);		
	}	

}
