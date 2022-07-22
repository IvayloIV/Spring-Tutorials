package com.pluralsight.springbootdata.service;

import com.pluralsight.springbootdata.entity.Flight;

public interface FlightService {

    void saveFlightWithoutTransaction(Flight flight);

    void saveFlightWithTransaction(Flight flight);
}
