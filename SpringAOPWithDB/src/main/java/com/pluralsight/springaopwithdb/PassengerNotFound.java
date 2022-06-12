package com.pluralsight.springaopwithdb;

public class PassengerNotFound extends RuntimeException {

    public PassengerNotFound(String message) {
        super(message);
    }
}
