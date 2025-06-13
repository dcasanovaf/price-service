package com.casanova.price.adapter.in.rest.models.api.v1;


import com.casanova.price.adapter.in.rest.models.dto.Price400Response;
import com.casanova.price.adapter.in.rest.models.dto.Price404Response;
import com.casanova.price.adapter.in.rest.models.dto.Price500Response;
import com.casanova.price.adapter.in.rest.models.dto.PriceResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The interface Prices api.
 */
@Validated
@Tag(name = "Prices", description = "the Prices API")
public interface PricesApi {

  /**
   * Price response entity.
   *
   * @param productId the product id
   * @param brandId   the brand id
   * @param date      the date
   * @return the response entity
   */
  @Operation(
        operationId = "price",
        tags = { "Prices" },
        responses = {
            @ApiResponse(responseCode = "200", description = "Ok", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PriceResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Price400Response.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Price404Response.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Price500Response.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/v1/prices",
        produces = { "application/json" }
    )
    ResponseEntity<PriceResponse> price(
        @NotNull @Parameter(name = "productId", description = "Numeric ID of the product", required = true) @Valid @RequestParam(value = "productId", required = true) Long productId,
        @NotNull @Parameter(name = "brandId", description = "Numeric ID of the brand", required = true) @Valid @RequestParam(value = "brandId", required = true) Long brandId,
        @NotNull @Parameter(name = "date", description = "Apply date pricing", required = true) @Valid @RequestParam(value = "date", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) java.time.LocalDateTime date
    );

}
