package com.pluralsight.springaopwithdb;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
public class CachingAspect {

    @Autowired
    private PassengerDao passengerDao;

    @Pointcut("execution(public * *.getById(..))")
    public void passengerGetById() {}

    @AfterReturning(value = "passengerGetById()", returning = "val")
    public void cachePassenger(Passenger val) {
        Map<Long, Passenger> passengers = passengerDao.getPassengers();
        if (!passengers.containsKey(val.getId())) {
            passengers.put(val.getId(), val);
        }
    }
}
