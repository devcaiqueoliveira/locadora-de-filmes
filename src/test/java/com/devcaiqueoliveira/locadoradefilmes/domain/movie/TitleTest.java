package com.devcaiqueoliveira.locadoradefilmes.domain.movie;

import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidMovieDataException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TitleTest {

    @Test
    void shouldThrowExceptionWhenTitleIsNull() {
        String invalidTitle = null;

        assertThrows(InvalidMovieDataException.class, () ->
                new Title(invalidTitle)
        );
    }

    void shouldThrowExceptionWhenTitleIsBlank() {
        String invalidTitle = "";

        assertThrows(InvalidMovieDataException.class, () ->
                new Title(invalidTitle)
        );
    }


}
