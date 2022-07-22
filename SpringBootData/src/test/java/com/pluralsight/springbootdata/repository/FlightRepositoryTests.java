package com.pluralsight.springbootdata.repository;

import com.pluralsight.springbootdata.entity.Flight;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@ExtendWith(SpringExtension.class)
//@DataMongoTest
@DataJpaTest
public class FlightRepositoryTests {

    @Autowired
    private FlightRepository flightRepository;

    @BeforeEach
    public void setUp() {
        flightRepository.deleteAll();
    }

    @Test
    public void testCRUDRepositoryFunctionality() {
        Flight flight = createFlight("London", "New York");
        flightRepository.save(flight);
        Assertions.assertThat(flightRepository.findAll())
            .hasSize(1)
            .first()
            .usingRecursiveComparison()
            .isEqualTo(flight);

        flightRepository.deleteById(flight.getId());
        Assertions.assertThat(flightRepository.findAll())
            .hasSize(0);
    }

    @Test
    public void shouldFindFlightsFromLondon() {
        Flight flight1 = createFlight("London", "New York");
        Flight flight2 = createFlight("London", "New York");
        Flight flight3 = createFlight("London", "New York");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        List<Flight> londonFlights = flightRepository.findByOrigin("London");
        Assertions.assertThat(londonFlights).hasSize(3);
        Assertions.assertThat(londonFlights.get(0)).usingRecursiveComparison().isEqualTo(flight1);
        Assertions.assertThat(londonFlights.get(2)).usingRecursiveComparison().isEqualTo(flight3);
    }

    @Test
    public void shouldFindFlightsFromLondonIgnoreCase() {
        Flight flight1 = createFlight("London", "New York");
        flightRepository.save(flight1);

        List<Flight> londonFlights = flightRepository.findByOriginIgnoreCase("LONDON");
        Assertions.assertThat(londonFlights)
            .hasSize(1)
            .first()
            .usingRecursiveComparison()
            .isEqualTo(flight1);
    }

    @Test
    public void shouldFindFlightsFromLondonOrParis() {
        Flight flight1 = createFlight("London", "New York");
        Flight flight2 = createFlight("New York", "Paris");
        Flight flight3 = createFlight("Paris", "London");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        List<Flight> flights = flightRepository.findByOriginIn(List.of("London", "Paris"));
        Assertions.assertThat(flights).hasSize(2);
        Assertions.assertThat(flights.get(0)).usingRecursiveComparison().isEqualTo(flight1);
        Assertions.assertThat(flights.get(1)).usingRecursiveComparison().isEqualTo(flight3);
    }

    @Test
    public void shouldFindFlightsFromNewYorkToParis() {
        Flight flight1 = createFlight("London", "New York");
        Flight flight2 = createFlight("New York", "Paris");
        Flight flight3 = createFlight("Paris", "London");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        List<Flight> flights = flightRepository.findByOriginAndDestination("New York", "Paris");
        Assertions.assertThat(flights).hasSize(1)
            .first()
            .usingRecursiveComparison()
            .isEqualTo(flight2);
    }

    @Test
    public void shouldFindSortedByOriginFlights() {
        Flight flight1 = createFlight("Paris", "London");
        Flight flight2 = createFlight("London", "New York");
        Flight flight3 = createFlight("New York", "Paris");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);

        Iterable<Flight> flights = flightRepository.findAll(Sort.by("origin"));
        Iterator<Flight> flightsIterator = flights.iterator();
        Assertions.assertThat(flights).hasSize(3);
        Assertions.assertThat(flightsIterator.next()).usingRecursiveComparison().isEqualTo(flight2);
        Assertions.assertThat(flightsIterator.next()).usingRecursiveComparison().isEqualTo(flight3);
        Assertions.assertThat(flightsIterator.next()).usingRecursiveComparison().isEqualTo(flight1);
    }

    @Test
    public void shouldFindSortedByOriginThenByDestinationDescFlights() {
        Flight flight1 = createFlight("Paris", "London");
        Flight flight2 = createFlight("London", "New York");
        Flight flight3 = createFlight("New York", "Paris");
        Flight flight4 = createFlight("New York", "Sofia");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);
        flightRepository.save(flight4);

        Iterable<Flight> flights = flightRepository.findAll(Sort.by("origin")
                .and(Sort.by(Sort.Direction.DESC, "destination")));
        Iterator<Flight> flightsIterator = flights.iterator();
        Assertions.assertThat(flights).hasSize(4);
        Assertions.assertThat(flightsIterator.next()).usingRecursiveComparison().isEqualTo(flight2);
        Assertions.assertThat(flightsIterator.next()).usingRecursiveComparison().isEqualTo(flight4);
        Assertions.assertThat(flightsIterator.next()).usingRecursiveComparison().isEqualTo(flight3);
        Assertions.assertThat(flightsIterator.next()).usingRecursiveComparison().isEqualTo(flight1);
    }

    @Test
    public void shouldFindSecondPageOfFlights() {
        for (int i = 1; i <= 50; i++) {
            flightRepository.save(createFlight(String.valueOf(i), String.valueOf(i + 10)));
        }

        Page<Flight> flightsPage = flightRepository.findAll(PageRequest.of(1, 5));
        Assertions.assertThat(flightsPage.getTotalElements()).isEqualTo(50);
        Assertions.assertThat(flightsPage.getTotalPages()).isEqualTo(10);
        Assertions.assertThat(flightsPage.getNumberOfElements()).isEqualTo(5);
        Assertions.assertThat(flightsPage.getContent()).extracting(Flight::getOrigin)
                .containsExactly("6", "7", "8", "9", "10");
    }

    @Test
    public void shouldSortByOriginDescAndFindFirstPageOfFlights() {
        for (int i = 1; i <= 50; i++) {
            flightRepository.save(createFlight(String.valueOf(i), String.valueOf(i + 10)));
        }

        Page<Flight> flightsPage = flightRepository
                .findAll(PageRequest.of(0, 6, Sort.by(Sort.Direction.DESC, "origin")));
        Assertions.assertThat(flightsPage.getTotalElements()).isEqualTo(50);
        Assertions.assertThat(flightsPage.getTotalPages()).isEqualTo(9);
        Assertions.assertThat(flightsPage.getNumberOfElements()).isEqualTo(6);
        Assertions.assertThat(flightsPage.getContent()).extracting(Flight::getOrigin)
                .containsExactly("9", "8", "7", "6", "50", "5");
    }

    @Test
    public void shouldFindFlightsFromLondonOrderedByDestination() {
        Flight flight1 = createFlight("London", "Paris");
        Flight flight2 = createFlight("New York", "Paris");
        Flight flight3 = createFlight("Paris", "London");
        Flight flight4 = createFlight("London", "New York");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        flightRepository.save(flight3);
        flightRepository.save(flight4);

        Page<Flight> flights = flightRepository.findByOrigin("London",
                PageRequest.of(0, 10, Sort.by("destination")));
        Assertions.assertThat(flights).hasSize(2);
        Assertions.assertThat(flights.getContent()).usingRecursiveComparison()
                .isEqualTo(List.of(flight4, flight1));
    }

    @Test
    public void shouldDeleteFlightByOrigin() {
        Flight flight1 = createFlight("London", "Paris");
        Flight flight2 = createFlight("Paris", "London");

        flightRepository.save(flight1);
        flightRepository.save(flight2);
        Assertions.assertThat(flightRepository.findAll()).hasSize(2);

        flightRepository.deleteByOrigin("London");
        Assertions.assertThat(flightRepository.findAll()).hasSize(1)
            .first()
            .usingRecursiveComparison()
            .isEqualTo(flight2);
    }

    public Flight createFlight(String origin, String destination) {
        Random random = new Random();
        int days = random.nextInt(6) + 5;

        Flight flight = new Flight();
        flight.setOrigin(origin);
        flight.setDestination(destination);
        flight.setScheduledAt(LocalDateTime.now().plusDays(days));
        return flight;
    }
}
