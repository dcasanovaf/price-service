package com.casanova.price.adapter.in.rest.mother;

import com.casanova.price.application.port.in.PriceCommand;
import com.casanova.price.domain.BrandId;
import com.casanova.price.domain.ProductId;
import java.time.LocalDateTime;
import lombok.experimental.UtilityClass;

/**
 * The type Price command mother.
 */
@UtilityClass
public class PriceCommandMother {

  /**
   * Price command with specific date price command.
   *
   * @param date the date
   * @return the price command
   */
  public PriceCommand priceCommandWithSpecificDate(LocalDateTime date) {
        return PriceCommand.builder()
                .productId(new ProductId(35455L))
                .brandId(new BrandId(1L))
                .date(date)
                .build();
    }

}
