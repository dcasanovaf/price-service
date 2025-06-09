package com.casanova.price.adapter.in.rest.exception;

import com.casanova.price.adapter.in.rest.models.dto.ErrorDto;
import com.casanova.price.adapter.in.rest.models.dto.Price400Response;
import com.casanova.price.domain.exception.PriceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * The type Global exception handler.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    /**
     * Handle generic exception response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        return ResponseEntity.internalServerError().build();
    }

    /**
     * Handle type mismatch response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        log.error("Error de conversión de tipo: {}", ex.getMessage());
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(new Price400Response().message("Formato inválido para " + ex.getName() +
                ". Se esperaba: " + ex.getRequiredType().getSimpleName()));
    }

    /**
     * Handle price not found exception response entity.
     *
     * @param ex the ex
     * @return the response entity
     */
    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<Object> handlePriceNotFoundException(PriceNotFoundException ex) {
        log.error("Precio no encontrado: {}", ex.getMessage());
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(new ErrorDto(ex.getMessage()));
    }
}