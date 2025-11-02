package com.devcaiqueoliveira.locadoradefilmes.domain.movie;

import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidMovieDataException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DurationTest {

    @Test
    void throwInvalidMovieDataExceptionWhenDurationIsBelowTheLimit() {
        int belowTheLimit = 14;

        assertThrows(InvalidMovieDataException.class, () ->
                new Duration(belowTheLimit)
        );
    }

    @Test
    void throwInvalidMovieDataExceptionWhenDurationIsAboveTheLimit() {
        int aboveTheLimit = 211;

        assertThrows(InvalidMovieDataException.class, () ->
                new Duration(aboveTheLimit)
        );
    }
}