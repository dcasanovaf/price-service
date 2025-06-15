package com.casanova.price.adapter.in.rest.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Error dto.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {
  private String message;
}