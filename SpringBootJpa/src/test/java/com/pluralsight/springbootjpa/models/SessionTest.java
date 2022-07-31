package com.pluralsight.springbootjpa.models;

import com.pluralsight.springbootjpa.repositories.SessionJpaRepository;
import com.pluralsight.springbootjpa.repositories.SessionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SessionTest {
    @Autowired
    private SessionRepository repository;

    @Autowired
    private SessionJpaRepository sessionJpaRepository;

    @Test
    public void test() throws Exception {
        List<Session> sessions = repository.getSessionsThatHaveName("Java");
        assertTrue(sessions.size() > 0);
    }

    @Test
    public void testJpaAuditing() {
        Session session = new Session();
        session.setSessionName("Learning Java together");
        session.setSessionDescription("You should have at least intermediate skills in Java to enroll for this course.");
        session.setSessionLength(120);

        sessionJpaRepository.saveAndFlush(session);
        Session savedSession = sessionJpaRepository.findById(session.getSessionId()).orElse(null);
        assertNotNull(savedSession);
    }

    @Test
    public void testJpaVersion() {
        Session session = sessionJpaRepository.findFirstBySessionNameContains("Learning Java together");
        session.setSessionLength(160);
        sessionJpaRepository.saveAndFlush(session);

        Session savedSession = sessionJpaRepository.findById(session.getSessionId()).orElse(null);
        assertNotNull(savedSession);
    }

}
