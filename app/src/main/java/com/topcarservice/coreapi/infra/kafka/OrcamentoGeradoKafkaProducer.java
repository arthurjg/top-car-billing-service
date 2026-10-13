package com.topcarservice.coreapi.infra.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoOrcamentoDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrcamentoGeradoKafkaProducer {
	
	private final KafkaTemplate<String, OrdemServicoOrcamentoDTO> kafkaTemplate;
	
	private static final String ORCAMENTO_GERADO_TOPIC = "orcamento-gerado";
	
	public void sendOrcamentoGeradoEvent(OrdemServicoOrcamentoDTO orcamento) {
		
		kafkaTemplate.send(ORCAMENTO_GERADO_TOPIC, orcamento);		
		
		log.info("Orçamento gerado evento enviado: {}", orcamento.getCodigoOrdemServico());
		
	}

}
