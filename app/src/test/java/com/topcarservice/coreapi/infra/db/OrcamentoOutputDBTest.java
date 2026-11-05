package com.topcarservice.coreapi.infra.db;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

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
class OrcamentoOutputDBTest {
	
	@InjectMocks
	OrcamentoOutputDB orcamentoOutputDB;
	
	@Mock
	OrcamentoRepository orcamentoRepository;
	
	@Mock
	OrcamentoDBMapper orcamentoDBMapper;

	@Test
	void testFindByCodigoOrdemServico() throws Exception {
		
		long codigoOS = 1L;
		
		var ordemServico = new OrdemServico();
		ordemServico.setCodigo(1L);
		ordemServico.setCliente("Artur");
		
		var orcamento = new OrdemServicoOrcamento(ordemServico);
		
		OrcamentoDBEntity orcamentoEntityMock = OrcamentoDBEntity.builder()
				.codigo(1L)
				.codigoOrdemServico(ordemServico.getCodigo())
				.valorTotal(new BigDecimal("100.00"))
				.build();
		
		when(orcamentoRepository.findByCodigoOrdemServico(codigoOS)).thenReturn(Optional.of(orcamentoEntityMock));
		
		when(orcamentoDBMapper.mapTo(orcamentoEntityMock)).thenReturn(orcamento);
		
		Optional<OrdemServicoOrcamento> orcamentoResult = orcamentoOutputDB.findByCodigoOrdemServico(codigoOS);
		
		assertTrue(orcamentoResult.isPresent());
	}

}
