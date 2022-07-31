package com.pluralsight.springbootjpa.repositories;

import com.pluralsight.springbootjpa.models.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SessionRepository {

    @Autowired
    private SessionJpaRepository sessionJpaRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Session create(Session session) {
//        entityManager.persist(session);
//        entityManager.flush();
//        return session;
        return sessionJpaRepository.saveAndFlush(session);
    }

    public Session update(Session session) {
//        session = entityManager.merge(session);
//        entityManager.flush();
//        return session;
        return sessionJpaRepository.saveAndFlush(session);
    }

    public void delete(Long id) {
//        entityManager.remove(find(id));
//        entityManager.flush();
        sessionJpaRepository.deleteById(id);
    }

    public Session find(Long id) {
//        return entityManager.find(Session.class, id);
        return sessionJpaRepository.getById(id);
    }

    public List<Session> list() {
//        return entityManager.createQuery("select s from Session s").getResultList();
        return sessionJpaRepository.findAll();
    }

    public List<Session> getSessionsThatHaveName(String name) {
//        List<Session> ses = entityManager
//                .createQuery("select s from Session s where s.sessionName like :name")
//                .setParameter("name", "%" + name + "%").getResultList();
//        return ses;
        return sessionJpaRepository.findBySessionNameContains(name);
    }
}
