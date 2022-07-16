package com.pluralsight.springjdbctemplate.repository;

import com.pluralsight.springjdbctemplate.model.Ride;

import java.util.List;

public interface RideRepository {

    List<Ride> getRides();

    Ride createRide(Ride ride);

    Ride getRide(int id);

    Ride updateRide(Ride ride);

    void batchUpdateRides(List<Object[]> elements);

    void deleteRide(Integer id);
}
