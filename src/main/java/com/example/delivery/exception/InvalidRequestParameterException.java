package com.example.delivery.exception;

public class InvalidRequestParameterException extends RuntimeException {

    public InvalidRequestParameterException(String errorMessage) {
        super(errorMessage);
    }
}
