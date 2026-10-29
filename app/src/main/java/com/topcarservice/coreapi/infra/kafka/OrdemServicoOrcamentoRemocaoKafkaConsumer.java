package com.topcarservice.coreapi.infra.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoOrcamentoDTO;
import com.topcarservice.coreapi.domain.usecases.OrcamentoOSUseCase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrdemServicoOrcamentoRemocaoKafkaConsumer {
	
	private static final String OS_ORCAMENTO_DESFAZER_TOPIC = "os-orcamento-desfazer";
	
	private final OrcamentoOSUseCase orcamentoOSUseCase;	

	@KafkaListener(topics = OS_ORCAMENTO_DESFAZER_TOPIC, groupId = "billing-service-group")
	public void recebeEventoOSAtualizada(OrdemServicoOrcamentoDTO orcamentoDTO) {
		
		log.info("OS orçamento remover recebida no tópico: {}.", orcamentoDTO.getCodigoOrdemServico());
			
		var orcamento = orcamentoOSUseCase.buscarPeloCodigoOrdemServico(orcamentoDTO.getCodigoOrdemServico());
		
		orcamentoOSUseCase.remover(orcamento);	
		
		log.info("Orçamento removido com sucesso OS: {}.", orcamento.getCodigoOrdemServico());		
		
	}

}
