package com.casanova.price.application.service;


import com.casanova.price.application.port.in.PriceCommand;
import com.casanova.price.application.port.in.PriceUseCase;
import com.casanova.price.application.port.out.PriceRepository;
import com.casanova.price.domain.TotalPrice;
import com.casanova.price.domain.exception.PriceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * The type Price service.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PriceService implements PriceUseCase {

    private final PriceRepository priceRepository;

    @Override
    public TotalPrice getPrice(PriceCommand priceCommand) {
        log.debug("Buscando precio para producto={}, marca={}, fecha={}",
            priceCommand.getProductId().getId(),
            priceCommand.getBrandId().getId(),
            priceCommand.getDate());

        TotalPrice result = priceRepository.findByProductIdAndBrandIdAndDate(
            priceCommand.getProductId(),
            priceCommand.getBrandId(),
            priceCommand.getDate()
        ).orElseThrow(() -> {
            log.error("Precio no encontrado para producto={}, marca={}, fecha={}",
                priceCommand.getProductId().getId(),
                priceCommand.getBrandId().getId(),
                priceCommand.getDate());
            return new PriceNotFoundException(
                priceCommand.getProductId(),
                priceCommand.getBrandId(),
                priceCommand.getDate()
            );
        });

        log.debug("Precio encontrado: {}", result);
        return result;
    }
}
