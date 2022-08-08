package com.pluralsight.springbootjsp.repositories;

import com.pluralsight.springbootjsp.model.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Person save(Person person) {
        if (person.getId() == null) {
            entityManager.persist(person);
        } else {
            person = entityManager.merge(person);
        }

        return person;
    }

    @Override
    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }
}
