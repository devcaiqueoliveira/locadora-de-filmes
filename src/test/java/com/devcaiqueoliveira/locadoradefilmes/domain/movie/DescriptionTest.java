package com.devcaiqueoliveira.locadoradefilmes.domain.movie;

import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidMovieDataException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DescriptionTest {

    @Test
    void throwInvalidMovieDataExceptionWhenDescriptionIsNull() {
        String invalidDescription = null;

        assertThrows(InvalidMovieDataException.class, () ->
                new Description(null)
        );
    }

    @Test
    void throwInvalidMovieDataExceptionWhenDescriptionIsBlank() {
        String invalidDescription = "";

        assertThrows(InvalidMovieDataException.class, () ->
                new Description("")
        );
    }
}