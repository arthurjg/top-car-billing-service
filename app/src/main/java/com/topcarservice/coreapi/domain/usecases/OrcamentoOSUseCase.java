package com.topcarservice.coreapi.domain.usecases;

import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;


public class OrcamentoOSUseCase {		

	//TODO TEMP/REMOVER! 
	public OrdemServicoOrcamento gerarOrcamento(OrdemServico ordemServico) {			
		
		return new OrdemServicoOrcamento(ordemServico);
		
	}
	
	//TODO TEMP/REMOVER! 
		/*public OrdemServicoOrcamento gerarOrcamento(OrdemServico ordemServico) {		
			
			List<OrcamentoItemDTO> itens = new ArrayList<>();
			
			List<OrcamentoItemDTO> servicos = ordemServico.getServicos()
					.stream()
					.map(servicoSolicitado -> OrcamentoItemDTO.builder()
							.descricao(servicoSolicitado.getNome())
							.quantidade(1)
							.valorUnitario(servicoSolicitado.getValorMaoDeObra())
							.valorTotal(servicoSolicitado.getValorMaoDeObra())
							.build())
					.toList();		
			
			List<OrcamentoItemDTO> pecasInsumos = 
					new ArrayList<>();
			
			itens.addAll(servicos);	
			itens.addAll(pecasInsumos);	
			
			return OrdemServicoOrcamentoDTO.builder()
					.codigoOrdemServico(ordemServico.getCodigo())
					.cliente(ordemServico.getCliente().getNome())
					.dataOrcamento(DateTimeUtil.formatarDataHora(LocalDateTime.now()))
					.itens(itens)
					.valorTotal(itens.stream()
							.map(OrcamentoItemDTO::getValorTotal)
							.reduce(BigDecimal.ZERO, BigDecimal::add))
					.build();
			
		}*/

	

}
