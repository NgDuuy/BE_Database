package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class BookstoreException extends RuntimeException {
    private final HttpStatus status;

    public BookstoreException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}