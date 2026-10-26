package com.topcarservice.coreapi.infra.http.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.topcarservice.coreapi.infra.http.client.dto.PagamentoDTO;

@FeignClient(name = "mercado-pago-api", url = "${mercadopago-api-url}")
public interface MercadoPagoClient {
	
	@PostMapping("/payments")
    void gerarPagamento(@RequestHeader("Authorization") String token,
    		@RequestHeader("X-Idempotency-Key") String idempotencyKey,
    		@RequestBody PagamentoDTO pagamentoDTO);

}
