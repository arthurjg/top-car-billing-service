package com.topcarservice.coreapi.adapters.gateways;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.topcarservice.coreapi.adapters.gateways.mappers.PagamentoMapper;
import com.topcarservice.coreapi.domain.entities.Pagamento;
import com.topcarservice.coreapi.domain.usecases.ports.PagamentoProcessamentoInputPort;
import com.topcarservice.coreapi.infra.http.client.MercadoPagoClient;
import com.topcarservice.coreapi.infra.http.client.dto.PagamentoDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PagamentoGateway implements PagamentoProcessamentoInputPort {
	
	@Autowired
	private MercadoPagoClient mercadoPagoClient;
	
	@Autowired
	private PagamentoMapper pagamentoMapper;
	
	@Value("${mercado-pago-token}")
	private String token;

	@Override
	public Pagamento processar(Pagamento pagamento) {
		
		PagamentoDTO pagamentoDTO = pagamentoMapper.map(pagamento);
		
		var idempotencyKey = UUID.randomUUID().toString();
		
		log.info("iniciando processamento de pagamento {}", pagamento.getCodigo());
		
		mercadoPagoClient.gerarPagamento(token, idempotencyKey, pagamentoDTO);
		
		log.info("processamento de pagamento concluido com sucesso {}", pagamento.getCodigo());
		
		return pagamento;
	}

}
