package com.topcarservice.coreapi.domain.usecases.ports;

import com.topcarservice.coreapi.domain.entities.Pagamento;

public interface PagamentoInputPort {

	Pagamento save(Pagamento pagamento);

}
