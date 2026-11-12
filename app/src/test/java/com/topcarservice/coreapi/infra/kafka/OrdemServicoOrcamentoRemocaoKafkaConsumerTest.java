package com.topcarservice.coreapi.infra.kafka;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoOrcamentoDTO;
import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;
import com.topcarservice.coreapi.domain.entities.StatusOrdemServico;
import com.topcarservice.coreapi.domain.usecases.OrcamentoOSUseCase;

@ExtendWith(MockitoExtension.class)
class OrdemServicoOrcamentoRemocaoKafkaConsumerTest {
	
	@InjectMocks
	OrdemServicoOrcamentoRemocaoKafkaConsumer consumer;
	
	@Mock
	OrcamentoOSUseCase orcamentoOSUseCase;

	@Test
	void testRecebeEventoOSAtualizada() throws Exception {		
		
		long codigoOrdemServico = 2L;
		
		var ordemServicoDTO = OrdemServicoOrcamentoDTO.builder()
				.codigoOrdemServico(codigoOrdemServico)
				.build();		
		
		var ordemServico = new OrdemServico();
		ordemServico.setCodigo(1L);
		ordemServico.setCliente("Artur");
		
		var orcamento = new OrdemServicoOrcamento(ordemServico);
		
		when(orcamentoOSUseCase.buscarPeloCodigoOrdemServico(codigoOrdemServico)).thenReturn(orcamento);
		
		consumer.recebeEventoOSAtualizada(ordemServicoDTO);
		
		verify(orcamentoOSUseCase).remover(orcamento);
	}

}
