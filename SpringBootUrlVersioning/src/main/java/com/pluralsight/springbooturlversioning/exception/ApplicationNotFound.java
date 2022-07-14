package com.pluralsight.springbooturlversioning.exception;

public class ApplicationNotFound extends RuntimeException {

    public ApplicationNotFound(String message) {
        super(message);
    }
}
