package com.topcarservice.coreapi.infra.kafka;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoRetornoDTO;
import com.topcarservice.coreapi.adapters.controllers.mappers.OrcamentoMapper;
import com.topcarservice.coreapi.adapters.controllers.mappers.OrdemServicoMapper;
import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.entities.StatusOrdemServico;
import com.topcarservice.coreapi.domain.usecases.AprovacaoOSUseCase;
import com.topcarservice.coreapi.domain.usecases.OrcamentoOSUseCase;

@ExtendWith(MockitoExtension.class)
class OrdemServicoAtualizadaKafkaConsumerTest {
	
	@InjectMocks
	OrdemServicoAtualizadaKafkaConsumer consumer;
	
	@Mock
	OrcamentoOSUseCase orcamentoOSUseCase;
	
	@Mock
	AprovacaoOSUseCase aprovacaoOSUseCase;
	
	@Mock
	OrdemServicoMapper ordemServicoMapper;
	
	@Mock
	OrcamentoMapper orcamentoMapper;
	
	@Mock
	OrcamentoGeradoKafkaProducer orcamentoGeradoKafkaProducer;

	@Test
	void testRecebeEventoOSAtualizada() throws Exception {		
		
		long codigoOrdemServico = 2L;
		
		var ordemServicoDTO = OrdemServicoRetornoDTO.builder()
				.codigo(codigoOrdemServico)
				.build();		
		
		var ordemServico = new OrdemServico();
		ordemServico.setCodigo(codigoOrdemServico);
		ordemServico.setStatus(StatusOrdemServico.EM_DIAGNOSTICO);
		
		when(ordemServicoMapper.map(ordemServicoDTO)).thenReturn(ordemServico);
		
		consumer.recebeEventoOSAtualizada(ordemServicoDTO);
		
		verify(orcamentoOSUseCase).gerarOrcamento(ordemServico);
		
		//verify(orcamentoGeradoKafkaProducer).sendOrcamentoGeradoEvent(ordemServico, StatusOrdemServico.AGUARDANDO_APROVACAO.getDescricao());
	}

}
