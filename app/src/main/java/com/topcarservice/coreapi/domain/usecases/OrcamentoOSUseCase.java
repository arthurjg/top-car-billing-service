package com.topcarservice.coreapi.domain.usecases;

import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;
import com.topcarservice.coreapi.domain.usecases.ports.OrcamentoInputPort;


public class OrcamentoOSUseCase {		
	
	private final OrcamentoInputPort inputPort;
	
	public OrcamentoOSUseCase(OrcamentoInputPort inputPort) {
		this.inputPort = inputPort;
	}
	
	public OrdemServicoOrcamento gerarOrcamento(OrdemServico ordemServico) {			
		
		var orcamento = new OrdemServicoOrcamento(ordemServico);
		
		inputPort.save(orcamento);
		
		return orcamento;
		
	}	

}
