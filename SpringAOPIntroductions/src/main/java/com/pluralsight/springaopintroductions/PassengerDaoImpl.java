package com.pluralsight.springaopintroductions;

import org.springframework.aop.support.DelegatingIntroductionInterceptor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PassengerDaoImpl extends DelegatingIntroductionInterceptor implements PassengerDao {

    private Map<Long, Passenger> passengers = new HashMap<>();

    public void insertRecord(String name) {
        Long passengerId = passengers.size() + 1L;
        this.passengers.put(passengerId, new Passenger(passengerId, name));
    }

    public Passenger getById(Long id) {
        return passengers.get(id);
    }
}
