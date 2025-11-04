package com.devcaiqueoliveira.locadoradefilmes.domain.common;

import com.devcaiqueoliveira.locadoradefilmes.domain.exception.InvalidUserDataException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CpfTest {

    @Test
    void shouldThrowExceptionWhenCpfLengthIsInvalid() {
        String invalidCpf = "1234567890";

        assertThrows(InvalidUserDataException.class, () ->
                new Cpf(invalidCpf)
        );
    }

    @Test
    void shouldCreateCpfWhenIsValid() {
        String validCpf = "12345678900";
        String expectedFormattedCpf = "12345678900";

        Cpf cpf = assertDoesNotThrow(() -> {
            return new Cpf(validCpf);
        });

        assertEquals(expectedFormattedCpf, cpf.getCpf());
    }

    @Test
    void shouldCreateCpfWhenGivenAFormattedDigitString() {
        String validFormattedCpf = "123.456.789-00";
        String expectedFormattedCpf = "12345678900";

        Cpf cpf = assertDoesNotThrow(() -> {
            return new Cpf(validFormattedCpf);
        });

        assertEquals(expectedFormattedCpf, cpf.getCpf());
    }

    @Test
    void shouldThrowExceptionWhenCpfIsInvalid() {
        String invalidCpf = "a*/1";

        assertThrows(InvalidUserDataException.class, () ->
                new Cpf(invalidCpf)
        );
    }

    @Test
    void validCpfFormat() {
        String invalidCpf = "123.456.789-0";

        assertThrows(InvalidUserDataException.class, () ->
                new Cpf(invalidCpf)
        );
    }


}
