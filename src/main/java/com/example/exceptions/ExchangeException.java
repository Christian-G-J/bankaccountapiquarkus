package com.example.exceptions;

public class ExchangeException extends RuntimeException {
    public ExchangeException(String message) {
        super(message);
    }
}