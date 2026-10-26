package com.topcarservice.coreapi.domain.usecases;

import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;
import com.topcarservice.coreapi.domain.usecases.ports.OrcamentoInputPort;
import com.topcarservice.coreapi.domain.usecases.ports.OrcamentoOutputPort;


public class OrcamentoOSUseCase {		
	
	private final OrcamentoInputPort inputPort;
	private final OrcamentoOutputPort outputPort;	
	
	public OrcamentoOSUseCase(OrcamentoInputPort inputPort, OrcamentoOutputPort outputPort) {
		super();
		this.inputPort = inputPort;
		this.outputPort = outputPort;
	}

	public OrdemServicoOrcamento gerarOrcamento(OrdemServico ordemServico) {			
		
		var orcamento = new OrdemServicoOrcamento(ordemServico);
		
		inputPort.save(orcamento);
		
		return orcamento;
		
	}	
	
	public OrdemServicoOrcamento buscarPeloCodigoOrdemServico(Long codigoOrdemServico) {			
		
		return outputPort.findByCodigoOrdemServico(codigoOrdemServico)
				.orElseThrow(() -> new IllegalArgumentException("Orçamento não encontrado para a Ordem de Serviço: " + codigoOrdemServico));
		
	}	
	
	

}
