package com.casanova.price.domain.mother;

import com.casanova.price.domain.*;
import java.time.LocalDateTime;
import lombok.experimental.UtilityClass;

/**
 * The type Total price mother.
 */
@UtilityClass
public class TotalPriceMother {
    /**
     * Total price with specific data total price.
     *
     * @return the total price
     */
    public TotalPrice totalPriceWithSpecificData() {
        return TotalPrice.builder()
                .productId(new ProductId(35455L))
                .brandId(new BrandId(1L))
                .priceList(new PriceList(1.0))
                .startDate(LocalDateTime.parse("2020-06-14T10:00:00.00"))
                .endDate(LocalDateTime.parse("2020-06-15T10:00:00.00"))
                .price(new Price(35.50))
                .build();
    }

    /**
     * Price with all data total price.
     *
     * @return the total price
     */
    public TotalPrice priceWithAllData() {
        return TotalPrice.builder()
                .productId(new ProductId(35455L))
                .brandId(new BrandId(1L))
                .priceList(new PriceList(1.0))
                .startDate(LocalDateTime.parse("2020-06-14T10:00:00.00"))
                .endDate(LocalDateTime.parse("2020-06-15T10:00:00.00"))
                .price(new Price(35.50))
                .priority(new Priority(1))
                .currency(new Currency("EUR"))
                .build();
    }

    /**
     * Price with all data and dates between 20200614 and 20201231 and priority 0 total price.
     *
     * @return the total price
     */
    public TotalPrice priceWithAllDataAndDatesBetween20200614And20201231AndPriority0() {
        return TotalPrice.builder()
                .productId(new ProductId(35455L))
                .brandId(new BrandId(1L))
                .priceList(new PriceList(1.0))
                .startDate(LocalDateTime.parse("2020-06-14T00:00:00.00"))
                .endDate(LocalDateTime.parse("2020-12-31T23:59:59.00"))
                .price(new Price(35.50))
                .priority(new Priority(0))
                .currency(new Currency("EUR"))
                .build();
    }

    /**
     * Price with all data and dates between 20200614 and 20200614 and priority 1 total price.
     *
     * @return the total price
     */
    public TotalPrice priceWithAllDataAndDatesBetween20200614And20200614AndPriority1() {
        return TotalPrice.builder()
                .productId(new ProductId(35455L))
                .brandId(new BrandId(1L))
                .priceList(new PriceList(2.0))
                .startDate(LocalDateTime.parse("2020-06-14T15:00:00.00"))
                .endDate(LocalDateTime.parse("2020-06-14T18:30:00.00"))
                .price(new Price(25.45))
                .priority(new Priority(1))
                .currency(new Currency("EUR"))
                .build();
    }

    /**
     * Price with all data and dates between 20200615 and 20200615 and priority 1 total price.
     *
     * @return the total price
     */
    public TotalPrice priceWithAllDataAndDatesBetween20200615And20200615AndPriority1() {
        return TotalPrice.builder()
                .productId(new ProductId(35455L))
                .brandId(new BrandId(1L))
                .priceList(new PriceList(3.0))
                .startDate(LocalDateTime.parse("2020-06-15T00:00:00.00"))
                .endDate(LocalDateTime.parse("2020-06-15T11:00:00.00"))
                .price(new Price(30.50))
                .priority(new Priority(1))
                .currency(new Currency("EUR"))
                .build();
    }

    /**
     * Price with all data and dates between 20200615 and 20201231 and priority 1 total price.
     *
     * @return the total price
     */
    public TotalPrice priceWithAllDataAndDatesBetween20200615And20201231AndPriority1() {
        return TotalPrice.builder()
                .productId(new ProductId(35455L))
                .brandId(new BrandId(1L))
                .priceList(new PriceList(4.0))
                .startDate(LocalDateTime.parse("2020-06-15T16:00:00.00"))
                .endDate(LocalDateTime.parse("2020-12-31T23:59:59.00"))
                .price(new Price(38.95))
                .priority(new Priority(1))
                .currency(new Currency("EUR"))
                .build();
    }
}
