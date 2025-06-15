package com.casanova.price.adapter.in.rest.mapper.in;

import com.casanova.price.application.port.in.PriceCommand;
import com.casanova.price.domain.BrandId;
import com.casanova.price.domain.ProductId;
import java.time.LocalDateTime;
import org.mapstruct.Mapper;

/**
 * The interface Price request mapper.
 */
@Mapper(componentModel = "spring")
public interface PriceRequestMapper {

  /**
   * To command price command.
   *
   * @param productId the product id
   * @param brandId   the brand id
   * @param date      the date
   * @return the price command
   */
  default PriceCommand toCommand(Long productId, Long brandId, LocalDateTime date) {
    return PriceCommand.builder()
        .productId(new ProductId(productId))
        .brandId(new BrandId(brandId))
        .date(date)
        .build();
  }
}
