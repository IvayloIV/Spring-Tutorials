package com.pluralsight.springboottesting.repository;

import com.pluralsight.springboottesting.entity.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
class ApplicationRepositoryTest {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    public void init() {
        testEntityManager.persist(new Application("Test1", "Desc", "Pesho"));
        testEntityManager.persist(new Application("Test2", "Desc", "Gosho"));
    }

    @Test
    public void testValidApplication_findById() {
        Application application = applicationRepository.findById(4L).get();
        Assertions.assertEquals("Test1", application.getName());
    }
}