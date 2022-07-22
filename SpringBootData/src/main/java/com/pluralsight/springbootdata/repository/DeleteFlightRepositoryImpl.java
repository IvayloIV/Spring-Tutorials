package com.pluralsight.springbootdata.repository;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class DeleteFlightRepositoryImpl implements DeleteFlightRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void deleteByOrigin(String origin) {
        entityManager.createQuery("DELETE FROM Flight f WHERE f.origin = :origin")
            .setParameter("origin", origin)
            .executeUpdate();
    }
}
