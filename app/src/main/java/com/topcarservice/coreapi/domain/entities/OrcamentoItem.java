package com.topcarservice.coreapi.domain.entities;

import java.math.BigDecimal;

public class OrcamentoItem {
	
	String descricao;
	Integer quantidade;
	private BigDecimal valorUnitario;
	private BigDecimal valorTotal;		
	
	@Deprecated
	public OrcamentoItem() {
		super();		
	}

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return "*----- descricao=" + descricao + ", quantidade=" + quantidade + ", valorUnitario="
				+ valorUnitario + ", valorTotal=" + valorTotal + "----*";
	}

}
