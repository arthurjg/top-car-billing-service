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
@Table(name = "orcamento")
public class OrcamentoDBEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	private Long codigo;
	
	private Long codigoOrdemServico;	
	
	private String cliente;		
	
	private LocalDateTime dataAbertura;
	
	private BigDecimal valorTotal;	

}
