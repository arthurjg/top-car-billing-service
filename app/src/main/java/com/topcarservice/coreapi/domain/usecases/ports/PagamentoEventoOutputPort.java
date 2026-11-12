package com.topcarservice.coreapi.domain.usecases.ports;

import com.topcarservice.coreapi.domain.entities.Pagamento;

public interface PagamentoEventoOutputPort {

	void enviaEventoPagamentoEfetuado(Pagamento pagamento);

}
