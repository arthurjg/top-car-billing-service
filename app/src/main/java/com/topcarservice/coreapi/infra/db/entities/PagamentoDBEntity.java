package com.topcarservice.coreapi.infra.db.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pagamento")
public class PagamentoDBEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	private String formaPagamento;
	private String statusPagamento;
	private String identificadorPagador;
	private String identificadorRecebedor;
	private LocalDateTime dataCriacao;
	private LocalDateTime dataPagamento;
	private BigDecimal valorTotal;	

}
