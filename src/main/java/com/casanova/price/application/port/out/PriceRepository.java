package com.casanova.price.application.port.out;

import com.casanova.price.domain.BrandId;
import com.casanova.price.domain.ProductId;
import com.casanova.price.domain.TotalPrice;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * The interface Price repository.
 */
public interface PriceRepository {

    /**
     * Find by product id and brand id and date optional.
     *
     * @param productId the product id
     * @param brandId   the brand id
     * @param date      the date
     * @return the optional
     */
    Optional<TotalPrice> findByProductIdAndBrandIdAndDate(ProductId productId, BrandId brandId, LocalDateTime date);
}