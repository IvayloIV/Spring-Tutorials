package com.pluralsight.springaopxml;

public class LogAspect {

    public void logBefore() {
        System.out.println("Before method execution.");
    }

    public void logAfter() {
        System.out.println("After method execution.");
    }
}
