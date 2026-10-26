package com.topcarservice.coreapi.domain.usecases.ports;

import com.topcarservice.coreapi.domain.entities.Pagamento;

public interface PagamentoProcessamentoInputPort {

	Pagamento processar(Pagamento pagamento);

}
