package com.topcarservice.coreapi.adapters.controllers.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.adapters.controllers.dto.OrdemServicoRetornoDTO;
import com.topcarservice.coreapi.domain.entities.OrdemServico;

@Component
public class OrdemServicoMapper {
	
	@Autowired
	private ModelMapper objectMapper;	

	public OrdemServico map(OrdemServicoRetornoDTO ordemServicoDto) {		
		return objectMapper.map(ordemServicoDto, OrdemServico.class);
	}		

}
