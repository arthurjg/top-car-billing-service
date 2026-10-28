package com.topcarservice.coreapi.domain.usecases;

import java.time.LocalDateTime;

import com.topcarservice.coreapi.domain.entities.OrdemServicoOrcamento;
import com.topcarservice.coreapi.domain.entities.Pagamento;
import com.topcarservice.coreapi.domain.usecases.ports.PagamentoEventoOutputPort;
import com.topcarservice.coreapi.domain.usecases.ports.PagamentoInputPort;
import com.topcarservice.coreapi.domain.usecases.ports.PagamentoOutputPort;
import com.topcarservice.coreapi.domain.usecases.ports.PagamentoProcessamentoInputPort;


public class PagamentoUseCase {
	
	private final PagamentoInputPort inputPort;
	private final PagamentoOutputPort outputPort;
	private final PagamentoProcessamentoInputPort pagamentoProcessamentoInputPort;	
	private final PagamentoEventoOutputPort pagamentoEventoOutputPort;	

	public PagamentoUseCase(PagamentoInputPort inputPort, PagamentoOutputPort outputPort,
			PagamentoProcessamentoInputPort pagamentoProcessamentoInputPort,
			PagamentoEventoOutputPort pagamentoEventoOutputPort) {
		super();
		this.inputPort = inputPort;
		this.outputPort = outputPort;
		this.pagamentoProcessamentoInputPort = pagamentoProcessamentoInputPort;
		this.pagamentoEventoOutputPort = pagamentoEventoOutputPort;
	}

	public Pagamento gerarPagamento(OrdemServicoOrcamento orcamento) {		
		
		return salvar(new Pagamento(orcamento, "PIX"));		
	}

	public Pagamento carregar(Long codigo) {
		return outputPort.findById(codigo)
				.orElseThrow(() -> new IllegalArgumentException("Pagamento não encontrado"));
	}
	
	public Pagamento efetuarPagamento(Pagamento pagamento) {		
		
		pagamento = pagamentoProcessamentoInputPort.processar(pagamento);
		pagamento.setDataPagamento(LocalDateTime.now());
		pagamento.setStatusPagamento("CONCLUIDO");
		
		pagamento = salvar(pagamento);
		
		pagamentoEventoOutputPort.enviaEventoPagamentoEfetuado(pagamento);
		return pagamento;		
	}
	
	private Pagamento salvar(Pagamento pagamento) {		
		return inputPort.save(pagamento);	
	}

	/*
	 * public void excluir(Pagamento Pagamento) { inputPort.delete(Pagamento); }
	 * 
	 * public List<Pagamento> listar() { return outputPort.findAll(); }
	 */

	

}
