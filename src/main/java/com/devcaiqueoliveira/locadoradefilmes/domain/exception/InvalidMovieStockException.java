package com.devcaiqueoliveira.locadoradefilmes.domain.exception;

public class InvalidMovieStockException extends RuntimeException {
  public InvalidMovieStockException(String message) {
    super(message);
  }
}
