package com.pluralsight.springbootswaggergroups.exception;

public class ApplicationNotFound extends RuntimeException {

    public ApplicationNotFound(String message) {
        super(message);
    }
}
