package com.topcarservice.coreapi.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pagamento {
	
	private Long codigo;
	private String formaPagamento;
	private String statusPagamento;
	private String identificadorPagador;
	private String identificadorRecebedor;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataPagamento;
	private BigDecimal valorTotal;	
	
	public Pagamento() {
		super();
		dataCriacao = LocalDateTime.now();
		statusPagamento = "PENDENTE";
	}
	
	public Pagamento(OrdemServico ordemServico) {
		this();
		
		identificadorPagador = ordemServico.getCliente().getCpf() != null 
				? ordemServico.getCliente().getCpf().toString() : ordemServico.getCliente().getCnpj();
		
		identificadorRecebedor = "TOPCARSERVICE LTDA";
		
		//valorTotal = 
		
		
		
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getFormaPagamento() {
		return formaPagamento;
	}
	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	public String getStatusPagamento() {
		return statusPagamento;
	}
	public void setStatusPagamento(String statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
	public String getIdentificadorPagador() {
		return identificadorPagador;
	}
	public void setIdentificadorPagador(String identificadorPagador) {
		this.identificadorPagador = identificadorPagador;
	}
	public String getIdentificadorRecebedor() {
		return identificadorRecebedor;
	}
	public void setIdentificadorRecebedor(String identificadorRecebedor) {
		this.identificadorRecebedor = identificadorRecebedor;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public LocalDateTime getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(LocalDateTime dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}	

}
