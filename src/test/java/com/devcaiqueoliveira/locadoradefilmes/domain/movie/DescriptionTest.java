package com.devcaiqueoliveira.locadoradefilmes.domain.movie;

import com.devcaiqueoliveira.locadoradefilmes.domain.common.Email;
import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidMovieDataException;
import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidUserDataException;
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
    public void shouldThrowExceptionWhenDescriptionIsEmpty() {
        String invalidDescription = " ";

        assertThrows(InvalidMovieDataException.class, () ->
                new Description(invalidDescription)
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