package com.casanova.price.adapter.out.persistence.mother;

import com.casanova.price.adapter.out.persistence.PriceJpaEntity;
import java.time.LocalDateTime;
import lombok.experimental.UtilityClass;

/**
 * The type Price jpa mother.
 */
@UtilityClass
public class PriceJpaMother {
  /**
   * Price with all data price jpa entity.
   *
   * @return the price jpa entity
   */
  public PriceJpaEntity priceWithAllData() {
        final var priceJpaEntity = new PriceJpaEntity();
        priceJpaEntity.setBrandId(1L);
        priceJpaEntity.setProductId(35455L);
        priceJpaEntity.setPriceList(1.0);
        priceJpaEntity.setStartDate(LocalDateTime.parse("2020-06-14T10:00:00.00"));
        priceJpaEntity.setEndDate(LocalDateTime.parse("2020-06-15T10:00:00.00"));
        priceJpaEntity.setPrice(35.50);
        priceJpaEntity.setPriority(1);
        priceJpaEntity.setCurrency("EUR");
        return priceJpaEntity;
    }
}
