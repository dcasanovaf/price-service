package com.casanova.price.domain;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

/**
 * The type Total price.
 */
@Data
@Builder(toBuilder = true)
public class TotalPrice {
  /**
   * The Product id.
   */
  @NotNull
  ProductId productId;

  /**
   * The Brand id.
   */
  @NotNull
  BrandId brandId;

  /**
   * The PriceList.
   */
  @NotNull
  PriceList priceList;

  /**
   * The Start date.
   */
  @NotNull
  LocalDateTime startDate;

  /**
   * The End date.
   */
  @NotNull
  LocalDateTime endDate;

  /**
   * The Price.
   */
  @NotNull
  Price price;

  /**
   * The Priority.
   */
  Priority priority;

  /**
   * The Currency.
   */
  Currency currency;

}
