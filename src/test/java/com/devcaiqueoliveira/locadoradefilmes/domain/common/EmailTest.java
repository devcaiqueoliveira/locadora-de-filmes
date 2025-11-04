package com.devcaiqueoliveira.locadoradefilmes.domain.common;

import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidUserDataException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    @Test
    public void shouldCreateEmailWhenFormatIsValid() {
        String validEmailFormat = "example@example.com";

        Email email = assertDoesNotThrow(() -> new Email(validEmailFormat));

        assertEquals(validEmailFormat, email.getEmail());
    }

    @Test
    public void shouldThrowExceptionWhenEmailFormatIsInvalid() {
        String invalidEmailFormat = "emailinvalidoteste";

        assertThrows(InvalidUserDataException.class, () ->
                new Email(invalidEmailFormat)
        );
    }

    @Test
    public void shouldThrowExceptionWhenEmailIsNull() {
        String invalidEmail = null;

        assertThrows(InvalidUserDataException.class, () ->
                new Email(invalidEmail)
        );
    }

    @Test
    public void shouldThrowExceptionWhenEmailIsBlank() {
        String invalidEmail = "";

        assertThrows(InvalidUserDataException.class, () ->
                new Email(invalidEmail)
        );
    }

    @Test
    public void shouldThrowExceptionWhenEmailIsEmpty() {
        String invalidEmail = " ";

        assertThrows(InvalidUserDataException.class, () ->
                new Email(invalidEmail)
        );
    }

}
