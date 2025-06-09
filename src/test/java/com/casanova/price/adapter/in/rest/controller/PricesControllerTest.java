package com.casanova.price.adapter.in.rest.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.casanova.price.adapter.in.rest.mapper.in.PriceRequestMapper;
import com.casanova.price.adapter.in.rest.mapper.out.PriceResponseMapper;
import com.casanova.price.application.port.in.PriceCommand;
import com.casanova.price.application.port.in.PriceUseCase;
import com.casanova.price.domain.BrandId;
import com.casanova.price.domain.Currency;
import com.casanova.price.domain.Price;
import com.casanova.price.domain.PriceList;
import com.casanova.price.domain.ProductId;
import com.casanova.price.domain.TotalPrice;
import com.casanova.price.adapter.in.rest.models.dto.PriceResponse;
import java.time.LocalDateTime;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * The type Prices controller test.
 */
@WebMvcTest(controllers = PricesController.class)
class PricesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceResponseMapper priceResponseMapper;

    @MockBean
    private PriceRequestMapper priceRequestMapper;

    @MockBean
    private PriceUseCase priceUseCase;

    /**
     * Gets prices with product id and brand and specific date should send command to use case.
     *
     * @param productId the product id
     * @param brandId   the brand id
     * @param date      the date
     * @throws Exception the exception
     */
    @ParameterizedTest
    @CsvSource({
        "35455, 1, 2020-06-14T10:00:00.00",
        "35455, 1, 2020-06-14T16:00:00.00",
        "35455, 1, 2020-06-14T21:00:00.00",
        "35455, 1, 2020-06-15T10:00:00.00",
        "35455, 1, 2020-06-16T21:00:00.00"
    })
    void getPricesWithProductIdAndBrandAndSpecificDateShouldSendCommandToUseCase(Long productId, Long brandId, LocalDateTime date) throws Exception {
        // Configuración de mocks
        PriceCommand priceCommand = PriceCommand.builder()
            .productId(new ProductId(productId))
            .brandId(new BrandId(brandId))
            .date(date)
            .build();
        when(priceRequestMapper.toCommand(productId, brandId, date)).thenReturn(priceCommand);

        TotalPrice totalPrice = TotalPrice.builder()
            .productId(new ProductId(productId))
            .brandId(new BrandId(brandId))
            .priceList(new PriceList(1.0))
            .startDate(date)
            .endDate(date.plusHours(1))
            .price(new Price(35.50))
            .currency(new Currency("EUR"))
            .build();
        when(priceUseCase.getPrice(any(PriceCommand.class))).thenReturn(totalPrice);

        PriceResponse priceResponse = new PriceResponse(productId, brandId, 1.0, date, date.plusHours(1), 35.50);
        when(priceResponseMapper.domainToApi(totalPrice)).thenReturn(priceResponse);

        // Ejecución del test
        mockMvc.perform(get("/prices")
                .param("productId", String.valueOf(productId))
                .param("brandId", String.valueOf(brandId))
                .param("date", date.toString())
                .header("Content-Type", "application/json"))
            .andExpect(status().isOk());
    }
}