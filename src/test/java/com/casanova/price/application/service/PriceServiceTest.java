package com.casanova.price.application.service;


import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;

import com.casanova.price.adapter.in.rest.mother.PriceCommandMother;
import com.casanova.price.application.port.in.PriceCommand;
import com.casanova.price.application.port.out.PriceRepository;
import com.casanova.price.domain.BrandId;
import com.casanova.price.domain.exception.PriceNotFoundException;
import com.casanova.price.domain.mother.TotalPriceMother;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * The type Price service test.
 */
@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceService priceService;

    /**
     * Gets price with price command with 2020 06 14 10 am date should return total price filtered by domain rules when database returns data.
     */
    @Test
    @DisplayName("Test 1: request at 10 am of 14th with product 35455 for the brand 1")
    void getPriceWithPriceCommandWith_2020_06_14_10am_DateShouldReturnTotalPriceFilteredByDomainRulesWhenDatabaseReturnsData() {
        PriceCommand priceCommand = PriceCommandMother.priceCommandWithSpecificDate(LocalDateTime.parse("2020-06-14T10:00:00.00"));
        final var expectedTotalPrice = TotalPriceMother.priceWithAllDataAndDatesBetween20200614And20201231AndPriority0();

        given(priceRepository.findByProductIdAndBrandIdAndDate(priceCommand.getProductId(), priceCommand.getBrandId(), priceCommand.getDate()))
                .willReturn(Optional.of(expectedTotalPrice));

        final var actualTotalPrice = priceService.getPrice(priceCommand);
        then(actualTotalPrice).isEqualTo(expectedTotalPrice);
    }

    /**
     * Gets price with price command with 2020 06 14 16 pm date should return total price filtered by domain rules when database returns data.
     */
    @Test
    @DisplayName("Test 2: request at 16 pm of 14th of 2020 with product 35455 for the brand 1")
    void getPriceWithPriceCommandWith_2020_06_14_16pm_DateShouldReturnTotalPriceFilteredByDomainRulesWhenDatabaseReturnsData() {
        PriceCommand priceCommand = PriceCommandMother.priceCommandWithSpecificDate(LocalDateTime.parse("2020-06-14T16:00:00.00"));
        final var expectedTotalPrice = TotalPriceMother.priceWithAllDataAndDatesBetween20200614And20200614AndPriority1();

        given(priceRepository.findByProductIdAndBrandIdAndDate(priceCommand.getProductId(), priceCommand.getBrandId(), priceCommand.getDate()))
            .willReturn(Optional.of(expectedTotalPrice));

        final var actualTotalPrice = priceService.getPrice(priceCommand);
        then(actualTotalPrice).isEqualTo(expectedTotalPrice);
    }

    /**
     * Gets price with price command with 2020 06 14 21 pm date should return total price filtered by domain rules when database returns data.
     */
    @Test
    @DisplayName("Test 3: request at 9 pm of 14th of 2020 with product 35455 for the brand 1")
    void getPriceWithPriceCommandWith_2020_06_14_21pm_DateShouldReturnTotalPriceFilteredByDomainRulesWhenDatabaseReturnsData() {
        PriceCommand priceCommand = PriceCommandMother.priceCommandWithSpecificDate(LocalDateTime.parse("2020-06-14T21:00:00.00"));
        final var expectedTotalPrice = TotalPriceMother.priceWithAllDataAndDatesBetween20200614And20201231AndPriority0();

        given(priceRepository.findByProductIdAndBrandIdAndDate(priceCommand.getProductId(), priceCommand.getBrandId(), priceCommand.getDate()))
            .willReturn(Optional.of(expectedTotalPrice));

        final var actualTotalPrice = priceService.getPrice(priceCommand);
        then(actualTotalPrice).isEqualTo(expectedTotalPrice);
    }

    /**
     * Gets price with price command with 2020 06 15 10 am date should return total price filtered by domain rules when database returns data.
     */
    @Test
    @DisplayName("Test 4: request at 10 am of 15th of 2020 with product 35455 for the brand 1")
    void getPriceWithPriceCommandWith_2020_06_15_10_am_DateShouldReturnTotalPriceFilteredByDomainRulesWhenDatabaseReturnsData() {
        PriceCommand priceCommand = PriceCommandMother.priceCommandWithSpecificDate(LocalDateTime.parse("2020-06-15T10:00:00.00"));
        final var expectedTotalPrice = TotalPriceMother.priceWithAllDataAndDatesBetween20200615And20200615AndPriority1();

        given(priceRepository.findByProductIdAndBrandIdAndDate(priceCommand.getProductId(), priceCommand.getBrandId(), priceCommand.getDate()))
            .willReturn(Optional.of(expectedTotalPrice));

        final var actualTotalPrice = priceService.getPrice(priceCommand);
        then(actualTotalPrice).isEqualTo(expectedTotalPrice);
    }

    /**
     * Gets price with price command with 2020 06 16 21 pm date should return total price filtered by domain rules when database returns data.
     */
    @Test
    @DisplayName("Test 5: request at 9pm of 16th of 2020 with product 35455 for the brand 1")
    void getPriceWithPriceCommandWith_2020_06_16_21pm_DateShouldReturnTotalPriceFilteredByDomainRulesWhenDatabaseReturnsData() {
        PriceCommand priceCommand = PriceCommandMother.priceCommandWithSpecificDate(LocalDateTime.parse("2020-06-16T21:00:00.00"));
        final var expectedTotalPrice = TotalPriceMother.priceWithAllDataAndDatesBetween20200615And20201231AndPriority1();

        given(priceRepository.findByProductIdAndBrandIdAndDate(priceCommand.getProductId(), priceCommand.getBrandId(), priceCommand.getDate()))
            .willReturn(Optional.of(expectedTotalPrice));

        final var actualTotalPrice = priceService.getPrice(priceCommand);
        then(actualTotalPrice).isEqualTo(expectedTotalPrice);
    }

    /**
     * Gets price with price command throw an error when product id not found.
     */
    @Test
    @DisplayName("Test 6: request at 9pm of 16th of 2020 with product 1000 for the brand 1")
    void getPriceWithPriceCommandThrowAnErrorWhenProductIdNotFound() {

        final PriceCommand priceCommand = PriceCommandMother.priceCommandWithSpecificDate(LocalDateTime.parse("2020-06-16T21:00:00.00"))
            .toBuilder()
            .brandId(new BrandId(1000L))
            .build();

        given(priceRepository.findByProductIdAndBrandIdAndDate(priceCommand.getProductId(), priceCommand.getBrandId(), priceCommand.getDate()))
            .willReturn(Optional.empty());

        Exception exception = Assertions.assertThrows(PriceNotFoundException.class, () -> priceService.getPrice(priceCommand));
        Assertions.assertEquals("No se encontró precio para producto=35455, marca=1000, fecha=2020-06-16T21:00", exception.getMessage());
    }

    /**
     * Gets price with price command throw an error when brand id not found.
     */
    @Test
    @DisplayName("Test 7: request at 9pm of 16th of 2020 with product 35455 for the brand 2")
    void getPriceWithPriceCommandThrowAnErrorWhenBrandIdNotFound() {
        final PriceCommand priceCommand = PriceCommandMother.priceCommandWithSpecificDate(LocalDateTime.parse("2020-06-16T21:00:00.00"))
            .toBuilder()
            .brandId(new BrandId(2L))
            .build();

        given(priceRepository.findByProductIdAndBrandIdAndDate(priceCommand.getProductId(), priceCommand.getBrandId(), priceCommand.getDate()))
            .willReturn(Optional.empty());

        Exception exception = Assertions.assertThrows(PriceNotFoundException.class, () -> priceService.getPrice(priceCommand));
        Assertions.assertEquals("No se encontró precio para producto=35455, marca=2, fecha=2020-06-16T21:00", exception.getMessage());
    }

    /**
     * Gets price with price command throw an error when data not exists in database.
     */
    @Test
    @DisplayName("Test 8: request at 9pm of 16th of 2022 with product 35455 for the brand 1")
    void getPriceWithPriceCommandThrowAnErrorWhenDataNotExistsInDatabase() {
        PriceCommand priceCommand = PriceCommandMother.priceCommandWithSpecificDate(LocalDateTime.parse("2022-06-16T21:00:00.00"));

        given(priceRepository.findByProductIdAndBrandIdAndDate(priceCommand.getProductId(), priceCommand.getBrandId(), priceCommand.getDate()))
            .willReturn(Optional.empty());

        Exception exception = Assertions.assertThrows(PriceNotFoundException.class, () -> priceService.getPrice(priceCommand));
        Assertions.assertEquals("No se encontró precio para producto=35455, marca=1, fecha=2022-06-16T21:00", exception.getMessage());
    }
}