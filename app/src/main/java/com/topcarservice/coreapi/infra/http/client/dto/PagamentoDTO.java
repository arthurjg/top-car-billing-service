package com.topcarservice.coreapi.infra.http.client.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PagamentoDTO {
	
	private BigDecimal transactionAmount;
    private Integer installments;
    private Boolean capture;
    private Boolean binaryMode;
    private String paymentMethodId;
    private String issuerId;
    private String token;
    private String externalReference;
    private String notificationUrl;
    private Metadata metadata;
    private Payer payer;
    private String statementDescriptor;
    private String description;
    private AdditionalInfo additionalInfo;

}
