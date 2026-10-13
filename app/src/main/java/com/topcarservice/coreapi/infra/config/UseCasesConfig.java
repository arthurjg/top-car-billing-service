package com.topcarservice.coreapi.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.topcarservice.coreapi.domain.usecases.AprovacaoOSUseCase;
import com.topcarservice.coreapi.domain.usecases.OrcamentoOSUseCase;
import com.topcarservice.coreapi.domain.usecases.ports.OrcamentoInputPort;

@Configuration
public class UseCasesConfig {	
	
	@Bean
	OrcamentoOSUseCase orcamentoOSUseCase(OrcamentoInputPort inputPort) {
		return new OrcamentoOSUseCase(inputPort);
	}
	
	@Bean
	AprovacaoOSUseCase aprovacaoOSUseCase() {
		return new AprovacaoOSUseCase();
	}

}
