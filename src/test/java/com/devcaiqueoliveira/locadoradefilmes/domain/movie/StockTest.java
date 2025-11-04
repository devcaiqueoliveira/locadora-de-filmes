package com.devcaiqueoliveira.locadoradefilmes.domain.movie;


import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidMovieDataException;
import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidMovieStockException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StockTest {

    @Test
    void shouldThrowExceptionWhenStockIsNegative() {
        assertThrows(InvalidMovieDataException.class, () ->
                new Stock(-5)
        );
    }

    @Test
    void shouldIncreaseTheStock() {
        int initialStock = 5;
        Stock stock = new Stock(initialStock);
        int expectedStock = 6;

        Stock newStock = stock.increase();

        assertEquals(expectedStock, newStock.getStock());
    }

    @Test
    void shouldDecreaseTheStock() {
        int initialStock = 5;
        Stock stock = new Stock(initialStock);
        int expectedStock = 4;

        Stock newStock = stock.decrease();

        assertEquals(expectedStock, newStock.getStock());
    }

    @Test
    void shouldPreventNegativeStockWhenDecrease() {
        int initialStock = 0;
        Stock stock = new Stock(initialStock);

        assertThrows(InvalidMovieStockException.class, stock::decrease);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionWhenRemoveQuantityIsNegative() {
        int initialStock = 10;
        Stock stock = new Stock(initialStock);

        assertThrows(InvalidMovieDataException.class, () ->
                stock.remove(-5)
        );
    }

}
