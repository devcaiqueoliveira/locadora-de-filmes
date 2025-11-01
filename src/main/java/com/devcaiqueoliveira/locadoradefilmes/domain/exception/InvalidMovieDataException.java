package com.devcaiqueoliveira.locadoradefilmes.domain.exception;

public class InvalidMovieDataException extends RuntimeException {
    public InvalidMovieDataException(String message) {
        super(message);
    }
}
