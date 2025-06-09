package com.casanova.price.domain.exception;

import com.casanova.price.domain.BrandId;
import com.casanova.price.domain.ProductId;
import java.time.LocalDateTime;

/**
 * The type Price not found exception.
 */
public class PriceNotFoundException extends DomainException {
    /**
     * Instantiates a new Price not found exception.
     *
     * @param productId the product id
     * @param brandId   the brand id
     * @param date      the date
     */
    public PriceNotFoundException(ProductId productId, BrandId brandId, LocalDateTime date) {
        super("No se encontró precio para producto=" + productId.getId() + 
              ", marca=" + brandId.getId() + ", fecha=" + date);
    }
}