package com.devcaiqueoliveira.locadoradefilmes.domain.common.util;

import java.util.function.Supplier;

public class ValidationUtils {

    public static void notNullOrBlank(String value, Supplier<? extends RuntimeException> exceptionSupplier) {
        if (value == null || value.isBlank()) {
            throw exceptionSupplier.get();
        }
    }

    public static void checkStringLength(String value, int min, int max, Supplier<? extends RuntimeException> exceptionSupplier) {
        int length = value.length();
        if (length < min || length > max) {
            throw exceptionSupplier.get();
        }
    }

    public static void checkExactLength(String value, int exactLength, Supplier<? extends RuntimeException> exceptionSupplier) {
        if (value.length() != exactLength) {
            throw exceptionSupplier.get();
        }
    }

}