package com.pluralsight.springaopxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PassengerDao passengerDao = context.getBean("passenger", PassengerDao.class);
        passengerDao.getById(1L);
    }
}
