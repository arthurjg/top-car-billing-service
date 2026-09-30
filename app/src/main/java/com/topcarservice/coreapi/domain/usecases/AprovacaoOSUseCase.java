package com.topcarservice.coreapi.domain.usecases;

import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;


public class AprovacaoOSUseCase {	

	public void enviarAprovacaoOrdemServico(OrdemServico ordemServico, OrdemServicoOrcamento orcamento) {
		// Lógica para enviar o orçamento para aprovação, por exemplo, por email ou notificações
		
		System.out.println("Enviando orçamento para aprovação:");
		System.out.println(orcamento);
		
	}

}
