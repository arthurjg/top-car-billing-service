package com.topcarservice.coreapi.infra.http.client.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class AdditionalInfoPayer {

    private String firstName;
    private String lastName;
    private String isPrimeUser;
    private String isFirstPurchaseOnline;
    private OffsetDateTime lastPurchase;
    private Phone phone;
    private AddressDTO address;
    private OffsetDateTime registrationDate;
}
