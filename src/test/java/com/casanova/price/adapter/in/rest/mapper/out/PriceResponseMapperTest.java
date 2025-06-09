package com.casanova.price.adapter.in.rest.mapper.out;

import static org.assertj.core.api.BDDAssertions.then;

import com.casanova.price.adapter.in.rest.mother.PriceResponseMother;
import com.casanova.price.domain.mother.TotalPriceMother;
import org.junit.jupiter.api.Test;

/**
 * The type Price response mapper test.
 */
class PriceResponseMapperTest {

    /**
     * The Price response mapper.
     */
    PriceResponseMapper priceResponseMapper = new PriceResponseMapperImpl();

    /**
     * Domain to api.
     */
    @Test
    void domainToApi() {
        final var totalPrice = TotalPriceMother.totalPriceWithSpecificData();

        final var actualPriceResponse = priceResponseMapper.domainToApi(totalPrice);

        final var expectedPriceResponse = PriceResponseMother.priceResponseWithSpecificData();
        then(actualPriceResponse).isEqualTo(expectedPriceResponse);
    }
}