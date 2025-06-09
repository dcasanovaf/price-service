package com.casanova.price.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.Value;

/**
 * The type Product id.
 */
@Value
public class ProductId {
    @NotEmpty(message = "Id it cannot be empty")
    Long id;
}
