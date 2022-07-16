package com.pluralsight.springjdbctemplate.util;

public class ServiceError {

    private String message;

    public ServiceError() {
    }

    public ServiceError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
