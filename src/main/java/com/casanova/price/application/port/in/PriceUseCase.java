package com.casanova.price.application.port.in;


import com.casanova.price.domain.TotalPrice;

/**
 * The interface Price use case.
 */
public interface PriceUseCase {
    /**
     * Gets price.
     *
     * @param priceCommand the price command
     * @return the price
     */
    TotalPrice getPrice(PriceCommand priceCommand);
}
