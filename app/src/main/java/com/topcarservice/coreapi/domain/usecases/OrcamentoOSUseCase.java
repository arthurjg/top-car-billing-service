package com.topcarservice.coreapi.domain.usecases;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.topcarservice.coreapi.adapters.controllers.dto.OrcamentoItemDTO;
import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoOrcamentoDTO;
import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.usecases.ports.OrdemServicoInputPort;
import com.topcarservice.coreapi.domain.usecases.ports.OrdemServicoOutputPort;
import com.topcarservice.coreapi.infra.utils.DateTimeUtil;


public class OrcamentoOSUseCase {
	
	private final OrdemServicoInputPort inputPort;
	private final OrdemServicoOutputPort outputPort;
	
	public OrcamentoOSUseCase(OrdemServicoInputPort inputPort, OrdemServicoOutputPort outputPort) {
		this.inputPort = inputPort;
		this.outputPort = outputPort;
	}

	//TODO TEMP/REMOVER! 
	public OrdemServicoOrcamentoDTO gerarOrcamento(OrdemServico ordemServico) {		
		
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
				/*ordemServico.getPecasInsumos()
				.stream()
				.map(pecaInsumoSolicitado -> OrcamentoItemDTO.builder()
						.descricao(pecaInsumoSolicitado.getNome())
						.quantidade(pecaInsumoSolicitado.getQuantidade())
						.valorUnitario(pecaInsumoSolicitado.getValorUnitario())
						.valorTotal(pecaInsumoSolicitado.getValorTotal())
						.build()) //TODO TEMP/REMOVER!
				.toList();	*/new ArrayList<>();
		
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
		
	}

	

}
