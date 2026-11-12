package com.topcarservice.coreapi.infra.db;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;
import com.topcarservice.coreapi.infra.db.entities.OrcamentoDBEntity;
import com.topcarservice.coreapi.infra.db.mappers.OrcamentoDBMapper;
import com.topcarservice.coreapi.infra.db.repositories.OrcamentoRepository;

@ExtendWith(MockitoExtension.class)
class OrcamentoInputDBTest {
	
	@InjectMocks
	OrcamentoInputDB orcamentoInputDB;
	
	@Mock
	OrcamentoRepository orcamentoRepository;
	
	@Mock
	OrcamentoDBMapper orcamentoDBMapper;

	@Test
	void testSave() throws Exception {
		
		var ordemServico = new OrdemServico();
		ordemServico.setCodigo(1L);
		ordemServico.setCliente("Artur");
		
		var orcamento = new OrdemServicoOrcamento(ordemServico);
		
		OrcamentoDBEntity orcamentoEntityMock = OrcamentoDBEntity.builder()
				.codigo(1L)
				.codigoOrdemServico(ordemServico.getCodigo())
				.valorTotal(new BigDecimal("100.00"))
				.build();
		
		when(orcamentoDBMapper.map(orcamento)).thenReturn(orcamentoEntityMock);
		
		orcamentoInputDB.save(orcamento);
		
		verify(orcamentoRepository).save(orcamentoEntityMock);
	}

	@Test
	void testDelete() throws Exception {
		
		var ordemServico = new OrdemServico();
		ordemServico.setCodigo(1L);
		ordemServico.setCliente("Artur");
		
		var orcamento = new OrdemServicoOrcamento(ordemServico);
		
		OrcamentoDBEntity orcamentoEntityMock = OrcamentoDBEntity.builder()
				.codigo(1L)
				.codigoOrdemServico(ordemServico.getCodigo())
				.valorTotal(new BigDecimal("100.00"))
				.build();
		
		when(orcamentoDBMapper.map(orcamento)).thenReturn(orcamentoEntityMock);
		
		orcamentoInputDB.delete(orcamento);
		
		verify(orcamentoRepository).delete(orcamentoEntityMock);
	}

}
