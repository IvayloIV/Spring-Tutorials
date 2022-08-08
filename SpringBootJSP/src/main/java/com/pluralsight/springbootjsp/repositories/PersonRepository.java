package com.pluralsight.springbootjsp.repositories;

import com.pluralsight.springbootjsp.model.Person;

public interface PersonRepository {
    Person save(Person person);

    Person findById(Long id);
}
