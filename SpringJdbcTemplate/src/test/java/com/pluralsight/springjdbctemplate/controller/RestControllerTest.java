package com.pluralsight.springjdbctemplate.controller;

import com.pluralsight.springjdbctemplate.model.Ride;
import com.pluralsight.springjdbctemplate.util.ServiceError;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestControllerTest {

    private Logger logger = Logger.getLogger(getClass());

    @Test
    public void testGetRides() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Ride>> ridesResponse = restTemplate.exchange(
                "http://localhost:8080/ride_tracker/rides", HttpMethod.GET,
                null, new ParameterizedTypeReference<List<Ride>>() {
                });
        List<Ride> rides = ridesResponse.getBody();

        for (Ride ride : rides) {
            System.out.println("Ride name: " + ride.getName());
        }
    }

    @Test
    public void testCreateRide() {
        RestTemplate restTemplate = new RestTemplate();

        Ride ride = new Ride();
        ride.setName("Ride name7");
        ride.setDuration(42);

        Ride rider = restTemplate.postForObject("http://localhost:8080/ride_tracker/ride", ride, Ride.class);
        logger.info(rider);
    }

    @Test
    public void testGetRide() {
        RestTemplate restTemplate = new RestTemplate();

        Ride ride = restTemplate.getForObject("http://localhost:8080/ride_tracker/ride/1", Ride.class);
        logger.info(ride);
    }

    @Test
    public void testUpdateRide() {
        RestTemplate restTemplate = new RestTemplate();

        Ride ride = restTemplate.getForObject("http://localhost:8080/ride_tracker/ride/1", Ride.class);
        ride.setName(ride.getName() + "123");
        ride.setDuration(ride.getDuration() + 10);

        restTemplate.put("http://localhost:8080/ride_tracker/ride", ride);
        logger.info(ride);
    }

    @Test
    public void testUpdateRides() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Ride>> ridesResponse = restTemplate.exchange(
            "http://localhost:8080/ride_tracker/rides", HttpMethod.GET,
            null, new ParameterizedTypeReference<>() {
            });
        List<Ride> rides = ridesResponse.getBody();
        rides.forEach(r -> {
            r.setName(r.getName() + 1);
            r.setDuration(r.getDuration() + 5);
        });

        restTemplate.put("http://localhost:8080/ride_tracker/rides", rides);
    }

    @Test
    public void testDeleteRide() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.delete("http://localhost:8080/ride_tracker/ride/1");
    }

    @Test
    public void testGetException() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.delete("http://localhost:8080/ride_tracker/ride/1");
        ServiceError serviceError = restTemplate.getForObject("http://localhost:8080/ride_tracker/ride/1",
                ServiceError.class);
        logger.info(serviceError.getMessage());
    }

    @Test
    public void testUpdateRidesException() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Ride>> ridesResponse = restTemplate.exchange(
                "http://localhost:8080/ride_tracker/rides", HttpMethod.GET,
                null, new ParameterizedTypeReference<>() {
                });
        List<Ride> rides = ridesResponse.getBody();
        rides.forEach(r -> r.setDuration(r.getDuration() + 1));
        rides.get(rides.size() - 1).setName(null);

        restTemplate.put("http://localhost:8080/ride_tracker/rides", rides);
    }
}
