package com.topcarservice.coreapi.infra.db;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;
import com.topcarservice.coreapi.domain.entities.Pagamento;
import com.topcarservice.coreapi.infra.db.entities.PagamentoDBEntity;
import com.topcarservice.coreapi.infra.db.mappers.PagamentoDBMapper;
import com.topcarservice.coreapi.infra.db.repositories.PagamentoRepository;

@ExtendWith(MockitoExtension.class)
class PagamentoInputDBTest {
	
	@InjectMocks
	PagamentoInputDB pagamentoInputDB;
	
	@Mock
	PagamentoRepository pagamentoRepository;
	
	@Mock
	PagamentoDBMapper pagamentoDBMapper;

	@Test
	void testSave() throws Exception {
		
		var ordemServico = new OrdemServico();
		ordemServico.setCodigo(1L);
		ordemServico.setCliente("Artur");
		
		var orcamento = new OrdemServicoOrcamento(ordemServico);		
		
		var pagamento = new Pagamento(orcamento, "PIX");
		
		PagamentoDBEntity pagamentoEntityMock = PagamentoDBEntity.builder()
				.codigo(pagamento.getCodigo())
				.codigoOrdemServico(ordemServico.getCodigo())
				.formaPagamento(pagamento.getFormaPagamento())
				.statusPagamento(pagamento.getStatusPagamento())
				.build();
		
		when(pagamentoDBMapper.map(pagamento)).thenReturn(pagamentoEntityMock);
		
		pagamentoInputDB.save(pagamento);
		
		verify(pagamentoRepository).save(pagamentoEntityMock);
	}

}
