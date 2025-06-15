package com.casanova.price.adapter.out.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Price jpa entity.
 */
@Entity
@Table(name = "prices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceJpaEntity {

  @Id
  @GeneratedValue
  private Long id;

  @Column
  private Long brandId;
  @Column
  private LocalDateTime startDate;
  @Column
  private LocalDateTime endDate;
  @Column
  private Double priceList;
  @Column
  private Long productId;
  @Column
  private Integer priority;
  @Column
  private Double price;
  @Column
  private String currency;
}
