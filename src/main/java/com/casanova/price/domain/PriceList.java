package com.casanova.price.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * The type PriceList.
 */
@Value
@AllArgsConstructor
public class PriceList {
    @NotEmpty(message = "PriceList it cannot be empty")
    Double priceList;
}
