package com.pluralsight.springbootdata.repository;

import com.pluralsight.springbootdata.entity.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FlightRepository extends PagingAndSortingRepository<Flight, Long>, DeleteFlightRepository {

    List<Flight> findByOrigin(String origin);

    List<Flight> findByOriginIgnoreCase(String origin);

    List<Flight> findByOriginIn(List<String> origins);

    List<Flight> findByOriginAndDestination(String origin, String destination);

    Page<Flight> findByOrigin(String origin, Pageable pageable);
}
