package com.topcarservice.coreapi.infra.http.client.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Item {

    private String id;
    private String title;
    private String description;
    private String pictureUrl;
    private String categoryId;
    private Integer quantity;
    private BigDecimal unitPrice;
}
