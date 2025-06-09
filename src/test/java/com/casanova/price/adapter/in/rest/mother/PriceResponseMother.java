package com.casanova.price.adapter.in.rest.mother;

import com.casanova.price.adapter.in.rest.models.dto.PriceResponse;
import java.time.LocalDateTime;
import lombok.experimental.UtilityClass;

/**
 * The type Price response mother.
 */
@UtilityClass
public class PriceResponseMother {

    /**
     * Price response with specific data price response.
     *
     * @return the price response
     */
    public PriceResponse priceResponseWithSpecificData() {
        return PriceResponse.builder()
            .productId(35455L)
            .brandId(1L)
            .priceList(1.0)
            .startDate(LocalDateTime.parse("2020-06-14T10:00:00.00"))
            .endDate(LocalDateTime.parse("2020-06-15T10:00:00.00"))
            .price(35.50)
            .build();
    }
}
