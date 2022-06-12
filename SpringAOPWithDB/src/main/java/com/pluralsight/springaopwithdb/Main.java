package com.pluralsight.springaopwithdb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        PassengerDao passengerDao = context.getBean(PassengerDao.class);
        passengerDao.createDb();
        passengerDao.insertRecord("Ivan");
        passengerDao.insertRecord("Tosho");
        passengerDao.insertRecord("Petur");

        passengerDao.getById(3L);
        passengerDao.getById(3L);
        passengerDao.getById(1L);
        passengerDao.getById(6L);
    }
}
