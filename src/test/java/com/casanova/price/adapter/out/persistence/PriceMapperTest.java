package com.casanova.price.adapter.out.persistence;

import static org.assertj.core.api.BDDAssertions.then;

import com.casanova.price.adapter.out.persistence.mapper.PriceMapper;
import com.casanova.price.adapter.out.persistence.mapper.PriceMapperImpl;
import com.casanova.price.adapter.out.persistence.mother.PriceJpaMother;
import com.casanova.price.domain.mother.TotalPriceMother;
import org.junit.jupiter.api.Test;

/**
 * The type Price mapper test.
 */
class PriceMapperTest {

    /**
     * The Price mapper.
     */
    PriceMapper priceMapper = new PriceMapperImpl();

    /**
     * Persistence to domain.
     */
    @Test
    void persistenceToDomain() {
        final var priceJpaEntity = PriceJpaMother.priceWithAllData();

        final var actualTotalPriceResponse = priceMapper.persistenceToDomain(priceJpaEntity);

        final var expectedTotalPrice = TotalPriceMother.priceWithAllData();
        then(actualTotalPriceResponse).isEqualTo(expectedTotalPrice);
    }
}