package com.pluralsight.springbootdata.repository;

public interface DeleteFlightRepository {

    void deleteByOrigin(String origin);
}
