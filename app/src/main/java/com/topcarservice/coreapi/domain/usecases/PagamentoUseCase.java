package com.topcarservice.coreapi.domain.usecases;

import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.usecases.ports.PagamentoInputPort;
import com.topcarservice.coreapi.domain.usecases.ports.PagamentoOutputPort;


public class PagamentoUseCase {
	
	private final PagamentoInputPort inputPort;
	private final PagamentoOutputPort outputPort;
	
	public PagamentoUseCase(PagamentoInputPort inputPort, PagamentoOutputPort outputPort) {
		this.inputPort = inputPort;
		this.outputPort = outputPort;
	}	
	
	public void gerarPagamento(OrdemServico ordemServico) {
		// TODO Auto-generated method stub		
		
	}

	/*public OrdemServico carregar(Long codigo) {
		
		return outputPort.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("OrdemServico não encontrado"));
	}

	public void excluir(OrdemServico ordemServico) {
		inputPort.delete(ordemServico);		
	}

	public List<OrdemServico> listar() {		
		return outputPort.findAll();
	}*/

	

}
