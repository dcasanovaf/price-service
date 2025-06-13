package com.casanova.price;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.casanova.price.adapter.in.rest.models.dto.PriceResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * The type Prices integration test.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PricesIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Should return price for product 35455 and brand 1 at 10 am.
     */
    @Test
    void shouldReturnPriceForProduct35455AndBrand1At10AM() {
        String url = "/v1/prices?productId=35455&brandId=1&date=2020-06-14T10:00:00";
        ResponseEntity<PriceResponse> response = restTemplate.getForEntity(url, PriceResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        PriceResponse priceResponse = response.getBody();
        assertThat(priceResponse).isNotNull();
        assertThat(priceResponse.getProductId()).isEqualTo(35455);
        assertThat(priceResponse.getBrandId()).isEqualTo(1);
        assertThat(priceResponse.getPrice()).isEqualTo(35.50);

    }

    /**
     * Should return price for product 35455 and brand 1 at 16 pm.
     */
    @Test
    void shouldReturnPriceForProduct35455AndBrand1At16PM() {
        String url = "/v1/prices?productId=35455&brandId=1&date=2020-06-14T16:00:00";
        ResponseEntity<PriceResponse> response = restTemplate.getForEntity(url, PriceResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        PriceResponse priceResponse = response.getBody();
        assertThat(priceResponse).isNotNull();
        assertThat(priceResponse.getProductId()).isEqualTo(35455);
        assertThat(priceResponse.getBrandId()).isEqualTo(1);
        assertThat(priceResponse.getPrice()).isEqualTo(25.45);
    }

    /**
     * Should return price for product 35455 and brand 1 at 21 pm.
     */
    @Test
    void shouldReturnPriceForProduct35455AndBrand1At21PM() {
        String url = "/v1/prices?productId=35455&brandId=1&date=2020-06-14T21:00:00";
        ResponseEntity<PriceResponse> response = restTemplate.getForEntity(url, PriceResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        PriceResponse priceResponse = response.getBody();
        assertThat(priceResponse).isNotNull();
        assertThat(priceResponse.getProductId()).isEqualTo(35455);
        assertThat(priceResponse.getBrandId()).isEqualTo(1);
        assertThat(priceResponse.getPrice()).isEqualTo(35.50);
    }

    /**
     * Should return price for product 35455 and brand 1 at 10 am on june 15.
     */
    @Test
    void shouldReturnPriceForProduct35455AndBrand1At10AMOnJune15() {
        String url = "/v1/prices?productId=35455&brandId=1&date=2020-06-15T10:00:00";
        ResponseEntity<PriceResponse> response = restTemplate.getForEntity(url, PriceResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        PriceResponse priceResponse = response.getBody();
        assertThat(priceResponse).isNotNull();
        assertThat(priceResponse.getProductId()).isEqualTo(35455);
        assertThat(priceResponse.getBrandId()).isEqualTo(1);
        assertThat(priceResponse.getPrice()).isEqualTo(30.50);
    }

    /**
     * Should return price for product 35455 and brand 1 at 21 pm on june 16.
     */
    @Test
    void shouldReturnPriceForProduct35455AndBrand1At21PMOnJune16() {
        String url = "/v1/prices?productId=35455&brandId=1&date=2020-06-16T21:00:00";
        ResponseEntity<PriceResponse> response = restTemplate.getForEntity(url, PriceResponse.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        PriceResponse priceResponse = response.getBody();
        assertThat(priceResponse).isNotNull();
        assertThat(priceResponse.getProductId()).isEqualTo(35455);
        assertThat(priceResponse.getBrandId()).isEqualTo(1);
        assertThat(priceResponse.getPrice()).isEqualTo(38.95);
    }
}