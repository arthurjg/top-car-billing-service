package com.topcarservice.coreapi.adapters.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.topcarservice.coreapi.adapters.controllers.dto.PagamentoDTO;
import com.topcarservice.coreapi.adapters.controllers.mappers.PagamentoMapper;
import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;
import com.topcarservice.coreapi.domain.entities.Pagamento;
import com.topcarservice.coreapi.domain.usecases.OrcamentoOSUseCase;
import com.topcarservice.coreapi.domain.usecases.PagamentoUseCase;

@WebMvcTest(PagamentoController.class)
class PagamentoControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	PagamentoUseCase pagamentoUseCase;
	
	@MockitoBean
	OrcamentoOSUseCase orcamentoOSUseCase;	
	
	@MockitoBean
	PagamentoMapper pagamentoMapper;
	
	OrdemServicoOrcamento orcamento;
	Pagamento pagamento;
	
	@BeforeEach
	public void init() throws Exception {
		
		var ordemServico = new OrdemServico();
		ordemServico.setCodigo(1L);
		ordemServico.setCliente("Artur");
		
		var orcamento = new OrdemServicoOrcamento(ordemServico);		
		
		pagamento = new Pagamento(orcamento, "PIX");	
	}

	@Test
	void testGerarPagamento() throws Exception {
		
		long idOs = 1L;
		
		PagamentoDTO param = PagamentoDTO.builder()
				.codigo(1L)
				.formaPagamento(pagamento.getFormaPagamento())
				.valorTotal(pagamento.getValorTotal())
				.statusPagamento(pagamento.getStatusPagamento())
				.build();					
		
		when(orcamentoOSUseCase.buscarPeloCodigoOrdemServico(idOs)).thenReturn(orcamento);
		when(pagamentoUseCase.gerarPagamento(orcamento)).thenReturn(pagamento);
		
		when(pagamentoMapper.map(pagamento)).thenReturn(param);
		
		mockMvc.perform(
				post("/admin/ordens-servico/orcamento/{id}/pagamento", 1L)					
				)		
			.andExpect(status().isOk());
	}

	@Test
	void testEfetuarPagamento() throws JsonProcessingException, Exception {
		long id = 1L;
		
		PagamentoDTO pagamentoDTO = PagamentoDTO.builder()
				.codigo(id)
				.formaPagamento(pagamento.getFormaPagamento())
				.valorTotal(pagamento.getValorTotal())
				.statusPagamento(pagamento.getStatusPagamento())
				.build();					
		
		when(pagamentoUseCase.carregar(id)).thenReturn(pagamento);
		when(pagamentoUseCase.efetuarPagamento(pagamento)).thenReturn(pagamento);
		
		when(pagamentoMapper.map(pagamento)).thenReturn(pagamentoDTO);
		
		mockMvc.perform(
				put("/admin/ordens-servico/orcamento/{id}/pagamento", 1L)						
				)		
			.andExpect(status().isOk());
	}
	
	@Test
	void testGerarPagamentoErroOrcamentoInexistente() throws Exception {
		
		long idOs = 1L;				
		
		when(orcamentoOSUseCase.buscarPeloCodigoOrdemServico(idOs)).thenThrow(new IllegalArgumentException("OrdemServico não encontrada"));
		
		mockMvc.perform(
				post("/admin/ordens-servico/orcamento/{id}/pagamento", idOs)					
				)		
			.andExpect(status().isNotFound());
	}

	@Test
	void testEfetuarPagamentoErroOrcamentoInexistente() throws JsonProcessingException, Exception {
		long id = 1L;				
		
		when(pagamentoUseCase.carregar(id)).thenThrow(new IllegalArgumentException("Pagamento não encontrado"));
		
		mockMvc.perform(
				put("/admin/ordens-servico/orcamento/{id}/pagamento", 1L)						
				)		
			.andExpect(status().isNotFound());
	}

}
