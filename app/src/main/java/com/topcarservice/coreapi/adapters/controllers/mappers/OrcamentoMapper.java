package com.topcarservice.coreapi.adapters.controllers.mappers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.adapters.controllers.dto.OrcamentoItemDTO;
import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoOrcamentoDTO;
import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;
import com.topcarservice.coreapi.infra.utils.DateTimeUtil;

@Component
public class OrcamentoMapper {
	
	@Autowired
	private ModelMapper objectMapper;	

	public OrdemServicoOrcamentoDTO map(OrdemServicoOrcamento ordemServicoOrcamento) {		
		
		List<OrcamentoItemDTO> itens = ordemServicoOrcamento.getItens().stream()
				.map(item -> objectMapper.map(item, OrcamentoItemDTO.class))
				.toList();
		
		return OrdemServicoOrcamentoDTO.builder()
				.codigoOrdemServico(ordemServicoOrcamento.getCodigoOrdemServico())
				.cliente(ordemServicoOrcamento.getCliente())
				.itens(itens)
				.dataOrcamento(DateTimeUtil.formatarDataHora(ordemServicoOrcamento.getDataOrcamento()))
				.valorTotal(ordemServicoOrcamento.getValorTotal())
				.build();
	}		

}
