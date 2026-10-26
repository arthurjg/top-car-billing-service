package com.topcarservice.coreapi.infra.db;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.domain.entities.Pagamento;
import com.topcarservice.coreapi.domain.usecases.ports.PagamentoOutputPort;
import com.topcarservice.coreapi.infra.db.mappers.PagamentoDBMapper;
import com.topcarservice.coreapi.infra.db.repositories.PagamentoRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class PagamentoOutputDB implements PagamentoOutputPort {
	
	private final PagamentoRepository pagamentoRepository;
	
	private final PagamentoDBMapper pagamentoDBMapper;

	@Override
	public Optional<Pagamento> findById(Long codigo) {	
		
		return pagamentoRepository.findById(codigo)
				.map(pagamentoDBMapper::mapTo);
	}	

}
