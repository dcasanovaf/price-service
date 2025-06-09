package com.casanova.price.application.port.out;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.casanova.price.domain.BrandId;
import com.casanova.price.domain.Currency;
import com.casanova.price.domain.Price;
import com.casanova.price.domain.PriceList;
import com.casanova.price.domain.Priority;
import com.casanova.price.domain.ProductId;
import com.casanova.price.domain.TotalPrice;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * The type Price repository test.
 */
@ExtendWith(MockitoExtension.class)
public class PriceRepositoryTest {

    @Mock
    private PriceRepository priceRepository;

    private ProductId productId;
    private BrandId brandId;
    private LocalDateTime date;
    private TotalPrice totalPrice;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        productId = new ProductId(1L);
        brandId = new BrandId(1L);
        date = LocalDateTime.now();
        totalPrice = TotalPrice.builder()
            .productId(productId)
            .brandId(brandId)
            .priceList(new PriceList(10.0))
            .startDate(date.minusDays(1))
            .endDate(date.plusDays(1))
            .price(new Price(100.0))
            .priority(new Priority(1))
            .currency(new Currency("USD"))
            .build();
    }

    /**
     * Test find by product id and brand id and date when called with valid parameters then returns expected value.
     */
    @Test
    void testFindByProductIdAndBrandIdAndDateWhenCalledWithValidParametersThenReturnsExpectedValue() {
        // Arrange
        given(priceRepository.findByProductIdAndBrandIdAndDate(productId, brandId, date)).willReturn(Optional.of(totalPrice));

        // Act
        Optional<TotalPrice> result = priceRepository.findByProductIdAndBrandIdAndDate(productId, brandId, date);

        // Assert
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(totalPrice);
    }

    /**
     * Test find by product id and brand id and date when called with null parameters then returns empty optional.
     */
    @Test
    void testFindByProductIdAndBrandIdAndDateWhenCalledWithNullParametersThenReturnsEmptyOptional() {
        // Arrange
        given(priceRepository.findByProductIdAndBrandIdAndDate(null, null, null)).willReturn(Optional.empty());

        // Act
        Optional<TotalPrice> result = priceRepository.findByProductIdAndBrandIdAndDate(null, null, null);

        // Assert
        assertThat(result).isEmpty();
    }

    /**
     * Test find by product id and brand id and date when called with date outside range then returns empty optional.
     */
    @Test
    void testFindByProductIdAndBrandIdAndDateWhenCalledWithDateOutsideRangeThenReturnsEmptyOptional() {
        // Arrange
        LocalDateTime outsideDate = date.plusDays(2);
        given(priceRepository.findByProductIdAndBrandIdAndDate(productId, brandId, outsideDate)).willReturn(Optional.empty());

        // Act
        Optional<TotalPrice> result = priceRepository.findByProductIdAndBrandIdAndDate(productId, brandId, outsideDate);

        // Assert
        assertThat(result).isEmpty();
    }
}