package com.casanova.price.domain;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * The type Brand id.
 */
@Value
@AllArgsConstructor
public class BrandId {
  @NotEmpty(message = "Id it cannot be empty")
  Long id;
}