package com.topcarservice.coreapi.adapters.gateways;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.topcarservice.coreapi.adapters.gateways.mappers.PagamentoMapper;
import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;
import com.topcarservice.coreapi.domain.entities.Pagamento;
import com.topcarservice.coreapi.infra.http.client.MercadoPagoClient;

@ExtendWith(MockitoExtension.class)
class PagamentoGatewayTest {
	
	@InjectMocks
	PagamentoGateway gateway;
	
	@Mock
	MercadoPagoClient mercadoPagoClient;
	
	@Mock
	PagamentoMapper pagamentoMapper;

	@Test
	void testProcessar() throws Exception {		
		
		var ordemServico = new OrdemServico();
		ordemServico.setCodigo(1L);
		ordemServico.setCliente("Artur");
		
		var orcamento = new OrdemServicoOrcamento(ordemServico);		
		
		var pagamento = new Pagamento(orcamento, "PIX");
		
		gateway.processar(pagamento);
		
		verify(mercadoPagoClient).gerarPagamento(any(), any(), any());
		
	}

}
