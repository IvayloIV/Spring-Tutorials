package com.pluralsight.springjdbctemplate.service;

import com.pluralsight.springjdbctemplate.model.Ride;
import com.pluralsight.springjdbctemplate.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RideServiceImpl implements RideService {

    @Autowired
    private RideRepository rideRepository;

    @Override
    public List<Ride> getRides() {
        return rideRepository.getRides();
    }

    @Override
    public Ride createRide(Ride ride) {
        return rideRepository.createRide(ride);
    }

    @Override
    public Ride getRide(int id) {
        return rideRepository.getRide(id);
    }

    @Override
    public Ride updateRide(Ride ride) {
        return rideRepository.updateRide(ride);
    }

    @Override
    @Transactional
    public void updateRides(List<Ride> rides) {
        List<Object[]> elements = rides.stream()
            .map(r -> new Object[]{r.getName(), r.getDuration(), r.getId()})
            .collect(Collectors.toList());

        rideRepository.batchUpdateRides(elements);
    }

    @Override
    public void deleteRide(Integer id) {
        rideRepository.deleteRide(id);
    }
}
