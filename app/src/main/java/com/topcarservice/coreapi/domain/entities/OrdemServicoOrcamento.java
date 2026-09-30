package com.topcarservice.coreapi.domain.entities;

import java.math.BigDecimal;
import java.util.List;

public class OrdemServicoOrcamento {
	
	Long codigoOrdemServico;	
	String cliente;
	List<OrcamentoItem> itens;	
	String dataOrcamento;	
	BigDecimal valorTotal;
	
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
