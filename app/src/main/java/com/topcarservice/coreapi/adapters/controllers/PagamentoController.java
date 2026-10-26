package com.topcarservice.coreapi.adapters.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topcarservice.coreapi.adapters.controllers.dto.PagamentoDTO;
import com.topcarservice.coreapi.adapters.controllers.mappers.PagamentoMapper;
import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;
import com.topcarservice.coreapi.domain.entities.Pagamento;
import com.topcarservice.coreapi.domain.usecases.OrcamentoOSUseCase;
import com.topcarservice.coreapi.domain.usecases.PagamentoUseCase;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "Pagamentos", description = "Gerenciamento de pagamentos de ordens de serviço")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/admin/ordens-servico/orcamento")
public class PagamentoController {
	
	PagamentoUseCase pagamentoUseCase;				
	
	OrcamentoOSUseCase orcamentoOSUseCase;	
	
	PagamentoMapper pagamentoMapper;		
	
	@PostMapping("/{id}/pagamento")
	public ResponseEntity<PagamentoDTO> gerarPagamento(@PathVariable("id") Long codigo) {			
		
		try {
			OrdemServicoOrcamento orcamento = orcamentoOSUseCase.buscarPeloCodigoOrdemServico(codigo);	
			
			var pagamento = pagamentoUseCase.gerarPagamento(orcamento);
			
			PagamentoDTO pagamentoResponse = pagamentoMapper.map(pagamento);
			
			log.info("Pagamento gerado com sucesso: {}", pagamentoResponse.getCodigo());
			
			return ResponseEntity.ok().body(pagamentoResponse);
		} catch (IllegalArgumentException e) {		
			log.error("Erro ao gerar pagamento: {}", e.getMessage());
			return ResponseEntity.notFound().build();
		} catch (IllegalStateException e) {			
			log.error("Erro ao gerar pagamento: {}", e.getMessage());
			return ResponseEntity.badRequest().build();
		}	
	}		
	
	@PutMapping("/{id}/pagamento")
	public ResponseEntity<PagamentoDTO> efetuarPagamento(@PathVariable("id") Long codigo) {			
		
		try {
			Pagamento pagamento = pagamentoUseCase.carregar(codigo);
			
			pagamento = pagamentoUseCase.efetuarPagamento(pagamento);			
			
			PagamentoDTO pagamentoResponse = pagamentoMapper.map(pagamento);
			
			log.info("Pagamento gerado com sucesso: {}", pagamentoResponse.getCodigo());
			
			return ResponseEntity.ok().body(pagamentoResponse);
		} catch (IllegalArgumentException e) {			
			log.error("Erro ao gerar pagamento: {}", e.getMessage());
			return ResponseEntity.notFound().build();
		} catch (IllegalStateException e) {			
			log.error("Erro ao gerar pagamento: {}", e.getMessage());
			return ResponseEntity.badRequest().build();
		}	
	}

}
