package com.example.exceptions;

public class AccountException extends RuntimeException {
    public AccountException(String message) {
        super(message);
    }
}