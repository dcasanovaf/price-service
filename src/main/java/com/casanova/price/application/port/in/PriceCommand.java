package com.casanova.price.application.port.in;


import com.casanova.price.domain.BrandId;
import com.casanova.price.domain.ProductId;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

/**
 * The type Price command.
 */
@Value
@Builder(toBuilder = true)
public class PriceCommand {
  @NonNull
  ProductId productId;

  @NonNull
  BrandId brandId;

  @NonNull
  LocalDateTime date;

}
