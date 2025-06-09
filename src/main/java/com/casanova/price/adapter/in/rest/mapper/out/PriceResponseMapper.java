package com.casanova.price.adapter.in.rest.mapper.out;


import com.casanova.price.adapter.in.rest.models.dto.PriceResponse;
import com.casanova.price.domain.TotalPrice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * The interface Price response mapper.
 */
@Mapper(componentModel = "spring")
public interface PriceResponseMapper {

  /**
   * Domain to api price response.
   *
   * @param totalPrice the total price
   * @return the price response
   */
  @Mapping(target = "productId", source = "productId.id")
  @Mapping(target = "brandId", source = "brandId.id")
  @Mapping(target = "priceList", source = "priceList.priceList")
  @Mapping(target = "startDate", source = "startDate")
  @Mapping(target = "endDate", source = "endDate")
  @Mapping(target = "price", source = "price.price")
  PriceResponse domainToApi(TotalPrice totalPrice);
}
