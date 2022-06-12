package com.pluralsight.springaopannotations;

public class PassengerNotFound extends RuntimeException {

    public PassengerNotFound(String message) {
        super(message);
    }
}
