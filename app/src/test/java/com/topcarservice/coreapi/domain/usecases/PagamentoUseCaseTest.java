package com.topcarservice.coreapi.domain.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.topcarservice.coreapi.domain.entities.Pagamento;
import com.topcarservice.coreapi.domain.usecases.ports.PagamentoEventoOutputPort;
import com.topcarservice.coreapi.domain.usecases.ports.PagamentoInputPort;
import com.topcarservice.coreapi.domain.usecases.ports.PagamentoOutputPort;
import com.topcarservice.coreapi.domain.usecases.ports.PagamentoProcessamentoInputPort;

@ExtendWith(MockitoExtension.class)
class PagamentoUseCaseTest {
	
	@InjectMocks
	PagamentoUseCase useCase;
	
	@Mock
	PagamentoInputPort inputPort;
	
	@Mock
	PagamentoOutputPort outputPort;
	
	@Mock
	PagamentoProcessamentoInputPort pagamentoProcessamentoInputPort;
	
	@Mock
	PagamentoEventoOutputPort pagamentoEventoOutputPort;

	@Test
	void testGerarPagamento() throws Exception {
		
		var ordemServico = new OrdemServico();
		ordemServico.setCodigo(1L);
		ordemServico.setCliente("Artur");
		
		var orcamento = new OrdemServicoOrcamento(ordemServico);		
		
		var pagamento = new Pagamento(orcamento, "PIX");	
		
		useCase.gerarPagamento(orcamento);
		
		verify(inputPort).save(pagamento);
	}

	@Test
	void testCarregar() throws Exception {
		
		var ordemServico = new OrdemServico();
		ordemServico.setCodigo(1L);
		ordemServico.setCliente("Artur");
		
		var orcamento = new OrdemServicoOrcamento(ordemServico);		
		
		var pagamento = new Pagamento(orcamento, "PIX");	
		
		long codigo = 1L;		
		
		when(outputPort.findById(codigo)).thenReturn(Optional.of(pagamento));
		
		Pagamento pagamentoResult = useCase.carregar(codigo);
		
		assertNotNull(pagamentoResult);
		assertEquals(pagamento.getCodigo(), pagamentoResult.getCodigo());
	}

	@Test
	void testEfetuarPagamento() throws Exception {
		
		var ordemServico = new OrdemServico();
		ordemServico.setCodigo(1L);
		ordemServico.setCliente("Artur");
		
		var orcamento = new OrdemServicoOrcamento(ordemServico);		
		
		var pagamento = new Pagamento(orcamento, "PIX");	
		
		when(pagamentoProcessamentoInputPort.processar(pagamento)).thenReturn(pagamento);
		
		useCase.efetuarPagamento(pagamento);
		
		verify(inputPort).save(pagamento);
	}

}
