package com.topcarservice.coreapi.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrdemServicoOrcamento {
	
	Long codigoOrdemServico;	
	Cliente cliente;
	List<OrcamentoItem> itens;	
	LocalDateTime dataOrcamento;	
	BigDecimal valorTotal;
	
	public OrdemServicoOrcamento() {
		super();		
		this.dataOrcamento = LocalDateTime.now();		
	}
	
	public OrdemServicoOrcamento(OrdemServico ordemServico) {
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

}
