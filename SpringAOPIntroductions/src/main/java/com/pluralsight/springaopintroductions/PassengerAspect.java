package com.pluralsight.springaopintroductions;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
//@Component
public class PassengerAspect {

    @DeclareParents(
        value = "com.pluralsight.springaopintroductions.Passenger",
        defaultImpl = PassengerDaoImpl.class
    )
    public PassengerDao passenger;
}
