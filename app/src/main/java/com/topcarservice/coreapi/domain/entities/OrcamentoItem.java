package com.topcarservice.coreapi.domain.entities;

import java.math.BigDecimal;

public class OrcamentoItem {
	
	String descricao;
	Integer quantidade;
	private BigDecimal valorUnitario;
	private BigDecimal valorTotal;
	
	@Override
	public String toString() {
		return "*----- descricao=" + descricao + ", quantidade=" + quantidade + ", valorUnitario="
				+ valorUnitario + ", valorTotal=" + valorTotal + "----*";
	}

}
