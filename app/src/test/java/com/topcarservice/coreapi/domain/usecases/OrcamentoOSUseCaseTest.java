package com.topcarservice.coreapi.domain.usecases;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;
import com.topcarservice.coreapi.domain.usecases.ports.OrcamentoInputPort;
import com.topcarservice.coreapi.domain.usecases.ports.OrcamentoOutputPort;

@ExtendWith(MockitoExtension.class)
class OrcamentoOSUseCaseTest {
	
	@InjectMocks
	OrcamentoOSUseCase useCase;
	
	@Mock
	OrcamentoInputPort inputPort;
	
	@Mock
	OrcamentoOutputPort outputPort;

	@Test
	void testGerarOrcamento() throws Exception {
		
		var ordemServico = new OrdemServico();
		ordemServico.setCodigo(1L);
		ordemServico.setCliente("Artur");
		
		var orcamento = new OrdemServicoOrcamento(ordemServico);
		
		useCase.gerarOrcamento(ordemServico);
		
		verify(inputPort).save(orcamento);
	}

	@Test
	void testBuscarPeloCodigoOrdemServico() {
		long codigo = 1L;		
		
		OrdemServicoOrcamento orcamentoMock = new OrdemServicoOrcamento();
		
		when(outputPort.findByCodigoOrdemServico(codigo)).thenReturn(Optional.of(orcamentoMock));
		
		OrdemServicoOrcamento orcamentoResult = useCase.buscarPeloCodigoOrdemServico(codigo);
		
		assertNotNull(orcamentoResult);
	}

	@Test
	void testRemover() throws Exception {
		
		var ordemServico = new OrdemServico();
		ordemServico.setCodigo(1L);
		ordemServico.setCliente("Artur");
		
		var orcamento = new OrdemServicoOrcamento(ordemServico);
		
		useCase.remover(orcamento);
		
		verify(inputPort).delete(orcamento);
		
	}

}
