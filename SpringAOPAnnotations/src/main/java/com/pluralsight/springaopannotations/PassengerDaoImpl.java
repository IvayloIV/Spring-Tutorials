package com.pluralsight.springaopannotations;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class PassengerDaoImpl implements PassengerDao {

    private Map<Long, Passenger> passengers = Map.of(
        1L, new Passenger(1L, "Ivan"),
        2L, new Passenger(2L, "Tosho"),
        3L, new Passenger(3L, "Petur")
    );

    @LogException
    public Passenger getById(Long id) {
        if (!passengers.containsKey(id)) {
            throw new PassengerNotFound(String.format("Passenger with id %d not found!", id));
        }

        Passenger passenger = passengers.get(id);
        System.out.println(passenger);
        return passenger;
    }
}
