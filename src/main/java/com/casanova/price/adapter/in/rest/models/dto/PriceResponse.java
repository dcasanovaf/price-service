package com.casanova.price.adapter.in.rest.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * The type Price response.
 */
@Value
@Builder
@AllArgsConstructor
public class PriceResponse {

    @JsonProperty("productId")
    Long productId;

    @JsonProperty("brandId")
    Long brandId;

    @JsonProperty("priceList")
    Double priceList;

    @JsonProperty("startDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    java.time.LocalDateTime startDate;

    @JsonProperty("endDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    java.time.LocalDateTime endDate;

    @JsonProperty("price")
    Double price;
}

