package com.pluralsight.springbootdata.repository;

import com.pluralsight.springbootdata.entity.Flight;
import com.pluralsight.springbootdata.service.FlightService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FlightServiceTests {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightService flightService;

    @BeforeEach
    public void setUp() {
        flightRepository.deleteAll();
    }

    @Test
    public void shouldSaveFlightWithoutTransaction() {
        try {
            flightService.saveFlightWithoutTransaction(new Flight());
        } catch (RuntimeException ex) {

        } finally {
            Assertions.assertThat(flightRepository.findAll()).isNotEmpty();
        }
    }

    @Test
    public void shouldSaveFlightWithTransaction() {
        try {
            flightService.saveFlightWithTransaction(new Flight());
        } catch (RuntimeException ex) {

        } finally {
            Assertions.assertThat(flightRepository.findAll()).isEmpty();
        }
    }
}
