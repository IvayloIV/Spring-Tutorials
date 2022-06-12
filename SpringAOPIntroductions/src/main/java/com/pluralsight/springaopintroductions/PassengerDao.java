package com.pluralsight.springaopintroductions;

public interface PassengerDao {

    public void insertRecord(String name);

    public Passenger getById(Long id);
}
