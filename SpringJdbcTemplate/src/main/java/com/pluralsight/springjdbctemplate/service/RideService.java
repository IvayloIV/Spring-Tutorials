package com.pluralsight.springjdbctemplate.service;

import com.pluralsight.springjdbctemplate.model.Ride;

import java.util.List;

public interface RideService {

    List<Ride> getRides();

    Ride createRide(Ride ride);

    Ride getRide(int id);

    Ride updateRide(Ride ride);

    void updateRides(List<Ride> rides);

    void deleteRide(Integer id);
}
