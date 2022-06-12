package com.pluralsight.springaopwithdb;

import java.util.Map;

public interface PassengerDao {

    public void createDb();

    public void insertRecord(String name);

    public Passenger getById(Long id);

    public Map<Long, Passenger> getPassengers();
}
