package com.topcarservice.coreapi.domain.usecases.ports;

import com.topcarservice.coreapi.domain.entities.OrdemServico;
import com.topcarservice.coreapi.domain.entities.Pagamento;

public interface PagamentoInputPort {

	OrdemServico save(Pagamento pagamento);

}
