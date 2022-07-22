package com.pluralsight.springbootdata.service;

import com.pluralsight.springbootdata.entity.Flight;
import com.pluralsight.springbootdata.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public void saveFlightWithoutTransaction(Flight flight) {
        flightRepository.save(flight);
        throw new RuntimeException();
    }

    @Override
    @Transactional
    public void saveFlightWithTransaction(Flight flight) {
        flightRepository.save(flight);
        throw new RuntimeException();
    }
}
