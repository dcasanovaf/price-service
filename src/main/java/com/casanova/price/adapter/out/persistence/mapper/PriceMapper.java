package com.casanova.price.adapter.out.persistence.mapper;


import com.casanova.price.adapter.out.persistence.PriceJpaEntity;
import com.casanova.price.domain.TotalPrice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

/**
 * The interface Price mapper.
 */
@Mapper(componentModel = "spring")
@Component
public interface PriceMapper {

    /**
     * Persistence to domain total price.
     *
     * @param priceJpaEntity the price jpa entity
     * @return the total price
     */
    @Mapping(target = "productId.id", source = "productId")
    @Mapping(target = "brandId.id", source = "brandId")
    @Mapping(target = "priceList.priceList", source = "priceList")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    @Mapping(target = "price.price", source = "price")
    @Mapping(target = "priority.value", source = "priority")
    @Mapping(target = "currency.isoCurr", source = "currency")
    TotalPrice persistenceToDomain(PriceJpaEntity priceJpaEntity);
}