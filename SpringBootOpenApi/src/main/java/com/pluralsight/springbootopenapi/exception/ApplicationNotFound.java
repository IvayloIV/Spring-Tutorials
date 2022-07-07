package com.pluralsight.springbootopenapi.exception;

public class ApplicationNotFound extends RuntimeException {

    public ApplicationNotFound(String message) {
        super(message);
    }
}
