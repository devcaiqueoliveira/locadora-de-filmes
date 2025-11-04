package com.devcaiqueoliveira.locadoradefilmes.domain.movie;

import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidMovieDataException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TitleTest {

    @Test
    void shouldThrowExceptionWhenTitleIsNull() {
        String invalidTitle = null;

        assertThrows(InvalidMovieDataException.class, () ->
                new Title(invalidTitle)
        );
    }

    @Test
    void shouldThrowExceptionWhenTitleIsBlank() {
        String invalidTitle = "";

        assertThrows(InvalidMovieDataException.class, () ->
                new Title(invalidTitle)
        );
    }

    @Test
    void shouldThrowExceptionWhenTitleIsEmpty() {
        String invalidTitle = " ";

        assertThrows(InvalidMovieDataException.class, () ->
                new Title(invalidTitle)
        );
    }


}
