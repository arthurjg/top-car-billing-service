package com.topcarservice.coreapi.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.topcarservice.coreapi.domain.usecases.AprovacaoOSUseCase;
import com.topcarservice.coreapi.domain.usecases.OrcamentoOSUseCase;
import com.topcarservice.coreapi.domain.usecases.PagamentoUseCase;
import com.topcarservice.coreapi.domain.usecases.ports.OrcamentoInputPort;
import com.topcarservice.coreapi.domain.usecases.ports.OrcamentoOutputPort;
import com.topcarservice.coreapi.domain.usecases.ports.PagamentoEventoOutputPort;
import com.topcarservice.coreapi.domain.usecases.ports.PagamentoInputPort;
import com.topcarservice.coreapi.domain.usecases.ports.PagamentoOutputPort;
import com.topcarservice.coreapi.domain.usecases.ports.PagamentoProcessamentoInputPort;

@Configuration
public class UseCasesConfig {	
	
	@Bean
	OrcamentoOSUseCase orcamentoOSUseCase(OrcamentoInputPort inputPort, OrcamentoOutputPort outputPort) {
		return new OrcamentoOSUseCase(inputPort, outputPort);
	}
	
	@Bean
	PagamentoUseCase pagamentoOSUseCase(PagamentoInputPort inputPort, 
			PagamentoOutputPort outputPort, PagamentoProcessamentoInputPort processamentoInputPort, 
			PagamentoEventoOutputPort eventoOutputPort) {
		
		return new PagamentoUseCase(
				inputPort, outputPort, processamentoInputPort, eventoOutputPort);
	}
	
	@Bean
	AprovacaoOSUseCase aprovacaoOSUseCase() {
		return new AprovacaoOSUseCase();
	}

}
