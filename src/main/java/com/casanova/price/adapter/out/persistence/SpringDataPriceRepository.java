package com.casanova.price.adapter.out.persistence;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * The interface Spring data price repository.
 */
interface SpringDataPriceRepository extends JpaRepository<PriceJpaEntity, Long> {

    /**
     * Find by product id and brand id list.
     *
     * @param productId the product id
     * @param brandId   the brand id
     * @return the list
     */
    List<PriceJpaEntity> findByProductIdAndBrandId(Long productId, Long brandId);

    /**
     * Find by product id and brand id and date list.
     *
     * @param productId the product id
     * @param brandId   the brand id
     * @param date      the date
     * @return the list
     */
    @Query("SELECT p FROM PriceJpaEntity p WHERE p.productId = :productId AND p.brandId = :brandId " +
        "AND :date BETWEEN p.startDate AND p.endDate ORDER BY p.priority DESC")
    List<PriceJpaEntity> findByProductIdAndBrandIdAndDate(Long productId, Long brandId, LocalDateTime date);
}