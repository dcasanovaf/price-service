package com.casanova.price.adapter.out.persistence;

import com.casanova.price.adapter.out.persistence.mapper.PriceMapper;
import com.casanova.price.application.port.out.PriceRepository;
import com.casanova.price.domain.BrandId;
import com.casanova.price.domain.ProductId;
import com.casanova.price.domain.TotalPrice;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * The type Price persistence adapter.
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class PricePersistenceAdapter implements PriceRepository {

  private final SpringDataPriceRepository springDataPriceRepository;
  private final PriceMapper priceMapper;


  @Override
  public Optional<TotalPrice> findByProductIdAndBrandIdAndDate(ProductId productId, BrandId brandId,
                                                               LocalDateTime date) {
    log.debug("Consultando precios para producto={}, marca={}, fecha={}",
        productId.getId(), brandId.getId(), date);

    List<PriceJpaEntity> priceEntities = springDataPriceRepository.findPrice(
        productId.getId(), brandId.getId(), date);

    log.debug("Precios encontrados en base de datos: {}",
        !priceEntities.isEmpty() ? "Sí" : "No");

    Optional<TotalPrice> result = priceEntities.isEmpty()
                                  ? Optional.empty()
                                  : Optional.of(priceMapper.persistenceToDomain(
                                    priceEntities.getFirst()));

    if (result.isPresent()) {
      log.debug("Precio seleccionado: {}", result.get());
    } else {
      log.debug("No se encontró ningún precio aplicable para la fecha especificada");
    }
    return result;
  }
}
