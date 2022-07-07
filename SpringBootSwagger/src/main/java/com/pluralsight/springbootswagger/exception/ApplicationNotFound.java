package com.pluralsight.springbootswagger.exception;

public class ApplicationNotFound extends RuntimeException {

    public ApplicationNotFound(String message) {
        super(message);
    }
}
