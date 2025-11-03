package com.devcaiqueoliveira.locadoradefilmes.domain.movie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TitleTest {

    @Test
    void shouldThrowExceptionWhenTitleIsNull() {
        String invalidTitle = null;

        assertThrows(IllegalArgumentException.class, () ->
                new Title(invalidTitle)
        );
    }

    @Test
    void shouldThrowExceptionWhenTitleIsBlank() {
        String invalidTitle = " ";

        assertThrows(IllegalArgumentException.class, () ->
                new Title(invalidTitle)
        );
    }
}
