package com.devcaiqueoliveira.locadoradefilmes.domain.common;

import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidUserDataException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class NameTest {

    @Test
    void shouldExceptionWhenNameIsBlank() {
        String invalidName = "";

        assertThrows(InvalidUserDataException.class, () ->
                new Name(invalidName)
        );
    }

    @Test
    void shouldExceptionWhenNameIsEmpty() {
        String invalidName = " ";

        assertThrows(InvalidUserDataException.class, () ->
                new Name(invalidName)
        );
    }

    @Test
    void shouldExceptionWhenNameIsNull() {
        String invalidName = null;

        assertThrows(InvalidUserDataException.class, () ->
                new Name(invalidName)
        );
    }
}
