package com.topcarservice.coreapi.infra.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoOrcamentoDTO;
import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoRetornoDTO;
import com.topcarservice.coreapi.adapters.controllers.mappers.OrcamentoMapper;
import com.topcarservice.coreapi.adapters.controllers.mappers.OrdemServicoMapper;
import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;
import com.topcarservice.coreapi.domain.usecases.OrcamentoOSUseCase;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrdemServicoAtualizadaKafkaConsumer {
	
	private static final String ORDEM_SERVICO_ATUALIZADA_TOPIC = "ordem-servico-atualizada";
	
	private final OrcamentoOSUseCase orcamentoOSUseCase;
	private final OrdemServicoMapper ordemServicoMapper;
	private final OrcamentoMapper orcamentoMapper;
	
	private final OrcamentoGeradoKafkaProducer orcamentoGeradoKafkaProducer;

	@KafkaListener(topics = ORDEM_SERVICO_ATUALIZADA_TOPIC, groupId = "billing-service-group")
	public void recebeEventoOSAtualizada(OrdemServicoRetornoDTO ordemServicoDTO) {
		
		log.info("OS atualizada recebida no tópico: {}.", ordemServicoDTO.getCodigo());
			
		OrdemServico ordemServico = ordemServicoMapper.map(ordemServicoDTO);
			
		OrdemServicoOrcamento orcamento = orcamentoOSUseCase.gerarOrcamento(ordemServico);	
		
		OrdemServicoOrcamentoDTO ordemServicoOrcamentoDTO = orcamentoMapper.map(orcamento);
		
		orcamentoGeradoKafkaProducer.sendOrcamentoGeradoEvent(ordemServicoOrcamentoDTO);
		
		log.info("Orçamento gerado para a OS: {}. Orçamento gerado Evento enviado", ordemServico.getCodigo());
	}

}
