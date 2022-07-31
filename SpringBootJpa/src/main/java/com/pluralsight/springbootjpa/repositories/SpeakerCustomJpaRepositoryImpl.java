package com.pluralsight.springbootjpa.repositories;

import com.pluralsight.springbootjpa.models.Speaker;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class SpeakerCustomJpaRepositoryImpl implements SpeakerCustomJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Speaker> findAllByTitle(String title) {
        TypedQuery<Speaker> query = entityManager
                .createQuery("SELECT s FROM Speaker s WHERE s.title = :title", Speaker.class);
        query.setParameter("title", title);
        return query.getResultList();
    }
}
