package com.casanova.price.adapter.in.rest.controller;


import com.casanova.price.adapter.in.rest.mapper.in.PriceRequestMapper;
import com.casanova.price.adapter.in.rest.mapper.out.PriceResponseMapper;
import com.casanova.price.adapter.in.rest.models.api.v1.PricesApi;
import com.casanova.price.adapter.in.rest.models.dto.PriceResponse;
import com.casanova.price.application.port.in.PriceCommand;
import com.casanova.price.application.port.in.PriceUseCase;
import com.casanova.price.domain.TotalPrice;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Prices controller.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class PricesController implements PricesApi {

  private final PriceUseCase priceUseCase;
  private final PriceResponseMapper priceResponseMapper;
  private final PriceRequestMapper priceRequestMapper;


  @Override
  public ResponseEntity<PriceResponse> price(Long productId, Long brandId, LocalDateTime date) {
    log.info("Solicitud recibida: productId={}, brandId={}, date={}", productId, brandId, date);
    final PriceCommand priceCommand = priceRequestMapper.toCommand(productId, brandId, date);
    final TotalPrice totalPrice = priceUseCase.getPrice(priceCommand);
    final PriceResponse pricesResponse = priceResponseMapper.domainToApi(totalPrice);
    log.info("Respuesta generada: {}", pricesResponse);
    return ResponseEntity.ok(pricesResponse);

  }
}
