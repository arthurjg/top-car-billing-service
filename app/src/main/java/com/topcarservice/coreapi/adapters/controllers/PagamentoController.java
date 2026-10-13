package com.topcarservice.coreapi.adapters.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoRetornoDTO;
import com.topcarservice.coreapi.adapters.controllers.mappers.OrdemServicoMapper;
import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;
import com.topcarservice.coreapi.domain.usecases.AprovacaoOSUseCase;
import com.topcarservice.coreapi.domain.usecases.OrcamentoOSUseCase;
//import com.topcarservice.coreapi.domain.usecases.OrdemServicoUseCase;
import com.topcarservice.coreapi.domain.usecases.PagamentoUseCase;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Ordem de Serviço", description = "Gerenciamento de ordens de serviço")
@AllArgsConstructor
@RestController
@RequestMapping("/admin/ordem-servicos")
public class PagamentoController {
	
	/*PagamentoUseCase pagamentoUseCase;	
	
	OrdemServicoUseCase ordemServicoUseCase;		
	
	OrcamentoOSUseCase orcamentoOSUseCase;
	
	AprovacaoOSUseCase aprovacaoOSUseCase;
	
	OrdemServicoMapper ordemServicoMapper;		
	
	@PostMapping("/{id}/pagamento")
	public ResponseEntity<OrdemServicoRetornoDTO> gerarPagamento(@PathVariable("id") Long codigo) {			
		
		try {
			OrdemServico ordemServico = ordemServicoUseCase.carregar(codigo);	
			
			pagamentoUseCase.gerarPagamento(ordemServico);
			
			OrdemServicoRetornoDTO ordemservicoResponse = ordemServicoMapper.map(ordemServico);
			
			return ResponseEntity.ok().body(ordemservicoResponse);
		} catch (IllegalArgumentException e) {			
			return ResponseEntity.notFound().build();
		} catch (IllegalStateException e) {			
			return ResponseEntity.badRequest().build();
		}	
	}	
	
	@PutMapping("/{id}/pagamento")
	public ResponseEntity<OrdemServicoRetornoDTO> efetuarPagamento(@PathVariable("id") Long codigo) {			
		
		try {
			OrdemServico ordemServico = ordemServicoUseCase.carregar(codigo);	
			
			OrdemServicoOrcamento ordemServicoOrcamento = orcamentoOSUseCase.gerarOrcamento(ordemServico);
		
			aprovacaoOSUseCase.enviarAprovacaoOrdemServico(ordemServico, ordemServicoOrcamento);
			
			OrdemServicoRetornoDTO ordemservicoResponse = ordemServicoMapper.map(ordemServico);
			
			return ResponseEntity.ok().body(ordemservicoResponse);
		} catch (IllegalArgumentException e) {			
			return ResponseEntity.notFound().build();
		} catch (IllegalStateException e) {			
			return ResponseEntity.badRequest().build();
		}	
	}	*/

}
