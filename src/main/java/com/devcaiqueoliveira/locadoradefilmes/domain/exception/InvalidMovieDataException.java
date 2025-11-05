package com.devcaiqueoliveira.locadoradefilmes.domain.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class InvalidMovieDataException extends RuntimeException {
    public InvalidMovieDataException(String message) {
        super(message);
    }
}
