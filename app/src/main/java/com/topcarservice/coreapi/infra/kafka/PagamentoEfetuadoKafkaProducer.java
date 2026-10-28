package com.topcarservice.coreapi.infra.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.adapters.controllers.dto.PagamentoDTO;
import com.topcarservice.coreapi.adapters.controllers.mappers.PagamentoMapper;
import com.topcarservice.coreapi.domain.entities.Pagamento;
import com.topcarservice.coreapi.domain.usecases.ports.PagamentoEventoOutputPort;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class PagamentoEfetuadoKafkaProducer implements PagamentoEventoOutputPort {
	
	private final KafkaTemplate<String, PagamentoDTO> kafkaTemplate;
	
	private final PagamentoMapper pagamentoMapper;
	
	private static final String PAGAMENTO_EFETUADO_TOPIC = "pagamento-efetuado";

	@Override
	public void enviaEventoPagamentoEfetuado(Pagamento pagamento) {
		
		var pagamentoDTO = pagamentoMapper.map(pagamento);		
		
		kafkaTemplate.send(PAGAMENTO_EFETUADO_TOPIC, pagamentoDTO);		
		
		log.info("pagamento efetuado evento enviado: {}, os: {}", 
				pagamento.getCodigo(), pagamento.getCodigoOrdemServico());
		
	}

}
