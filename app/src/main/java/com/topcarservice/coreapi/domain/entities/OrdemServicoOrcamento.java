package com.topcarservice.coreapi.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrdemServicoOrcamento {
	
	private Long codigoOrdemServico;	
	private String cliente;
	private List<OrcamentoItem> itens;	
	private LocalDateTime dataOrcamento;	
	private BigDecimal valorTotal;
	
	public OrdemServicoOrcamento() {
		super();		
		itens = new ArrayList<>();
		this.dataOrcamento = LocalDateTime.now();		
	}
	
	public OrdemServicoOrcamento(OrdemServico ordemServico) throws Exception {
		this();
		this.codigoOrdemServico = ordemServico.getCodigo();
		this.cliente = ordemServico.getCliente();
		
		ordemServico.getServicos().forEach(servicoSolicitado -> {
			OrcamentoItem item = new OrcamentoItem(
					servicoSolicitado.getNome(), 
					1, 
					servicoSolicitado.getValorMaoDeObra(), 
					servicoSolicitado.getValorMaoDeObra());
			this.itens.add(item);
		});
		
		boolean itensInconsistente = ordemServico.getPecasInsumos().stream()
			.anyMatch((pecasInsumo) -> pecasInsumo.getQuantidade() == 0);
		
		if(itensInconsistente) {
			throw new Exception("Ordem de Serviço invalida para geração de orçamento - valores de itens invalidos. "); 
		}
			
		
		ordemServico.getPecasInsumos().forEach(pecaInsumoSolicitado -> {
			OrcamentoItem item = new OrcamentoItem(
					pecaInsumoSolicitado.getNome(), 
					pecaInsumoSolicitado.getQuantidade(), 
					pecaInsumoSolicitado.getValorUnitario(), 
					new BigDecimal(pecaInsumoSolicitado.getQuantidade()).multiply( pecaInsumoSolicitado.getValorUnitario()));
			this.itens.add(item);
		});
			
		this.valorTotal = this.itens.stream()
				.map(OrcamentoItem::getValorTotal)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}	
	
	@Deprecated
	public OrdemServicoOrcamento(Long codigoOrdemServico, String cliente, List<OrcamentoItem> itens,
			LocalDateTime dataOrcamento, BigDecimal valorTotal) {
		super();
		this.codigoOrdemServico = codigoOrdemServico;
		this.cliente = cliente;
		this.itens = itens;
		this.dataOrcamento = dataOrcamento;
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return "+-----------Ordem Servico Orcamento -----------*\n" +
				"+-----codigoOrdemServico=" + codigoOrdemServico + "--------+\n" +
				"+-----cliente=" + cliente + "--------+\n" +
				"+-----itens=" + itens + "--------+\n" +
				"+-----dataOrcamento=" + dataOrcamento + "--------+\n" +
				"+-----valorTotal=" + valorTotal + "--------+\n" +
				"+---------------------------------------------+\n";
						
	}

	public Long getCodigoOrdemServico() {
		return codigoOrdemServico;
	}

	public void setCodigoOrdemServico(Long codigoOrdemServico) {
		this.codigoOrdemServico = codigoOrdemServico;
	}

	public String getCliente() {
		return cliente;
	}	

	public List<OrcamentoItem> getItens() {
		return itens;
	}

	public void setItens(List<OrcamentoItem> itens) {
		this.itens = itens;
	}

	public LocalDateTime getDataOrcamento() {
		return dataOrcamento;
	}

	public void setDataOrcamento(LocalDateTime dataOrcamento) {
		this.dataOrcamento = dataOrcamento;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}	

}
