package com.pluralsight.springjdbctemplate.controller;

import com.pluralsight.springjdbctemplate.model.Ride;
import com.pluralsight.springjdbctemplate.service.RideService;
import com.pluralsight.springjdbctemplate.util.ServiceError;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RideController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private RideService rideService;

    @RequestMapping(value = "/rides", method = RequestMethod.GET)
    public List<Ride> getRides() {
        return rideService.getRides();
    }

    @RequestMapping(value = "/ride", method = RequestMethod.POST)
    public Ride createRide(@RequestBody Ride ride) {
        return rideService.createRide(ride);
    }

    @RequestMapping(value = "/ride/{id}", method = RequestMethod.GET)
    public Ride getRide(@PathVariable int id) {
        return rideService.getRide(id);
    }

    @RequestMapping(value = "/ride", method = RequestMethod.PUT)
    public Ride updateRide(@RequestBody Ride ride) {
        return rideService.updateRide(ride);
    }

    @RequestMapping(value = "/rides", method = RequestMethod.PUT)
    public void updateRides(@RequestBody List<Ride> rides) {
        rideService.updateRides(rides);
    }

    @RequestMapping(value = "/ride/{id}", method = RequestMethod.DELETE)
    public void deleteRide(@PathVariable int id) {
        rideService.deleteRide(id);
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<ServiceError> handleException(DataAccessException ex) {
        ServiceError serviceError = new ServiceError(ex.getMessage());
        logger.info(ex.getMessage());
        return ResponseEntity.ok(serviceError);
    }
}
