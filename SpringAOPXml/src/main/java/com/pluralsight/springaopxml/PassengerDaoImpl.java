package com.pluralsight.springaopxml;

import java.util.Map;

public class PassengerDaoImpl implements PassengerDao {

    private Map<Long, Passenger> passengers = Map.of(
        1L, new Passenger(1L, "Ivan"),
        2L, new Passenger(2L, "Tosho"),
        3L, new Passenger(3L, "Petur")
    );

    @Override
    public Passenger getById(Long id) {
        Passenger passenger = passengers.get(id);
        System.out.println(passenger);
        return passenger;
    }
}
