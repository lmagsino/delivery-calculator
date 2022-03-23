package com.example.delivery.controller;

import com.example.delivery.exception.InvalidRequestParameterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(InvalidRequestParameterException.class)
    public ResponseEntity handleInvalidRequestParameterException(InvalidRequestParameterException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity handleHttpClientErrorException(HttpClientErrorException e) {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(HttpClientErrorException e) {
        return new ResponseEntity("Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
