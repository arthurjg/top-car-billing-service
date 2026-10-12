package com.topcarservice.coreapi.domain.entities;

import java.math.BigDecimal;

public class OrcamentoItem {
	
	String descricao;
	Integer quantidade;
	private BigDecimal valorUnitario;
	private BigDecimal valorTotal;	
	
	public OrcamentoItem(String descricao, Integer quantidade, BigDecimal valorUnitario, BigDecimal valorTotal) {
		super();
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorTotal;
	}	

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	@Override
	public String toString() {
		return "*----- descricao=" + descricao + ", quantidade=" + quantidade + ", valorUnitario="
				+ valorUnitario + ", valorTotal=" + valorTotal + "----*";
	}

}
