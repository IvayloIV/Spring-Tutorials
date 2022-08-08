package com.pluralsight.springbootjsp.services;

import com.pluralsight.springbootjsp.model.Person;
import org.springframework.transaction.annotation.Transactional;

public interface PersonService {
    Person addPerson(Person person);
}
