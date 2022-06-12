package com.pluralsight.springboottesting.service;

import com.pluralsight.springboottesting.entity.Application;
import com.pluralsight.springboottesting.repository.ApplicationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
class ApplicationServiceTest {

    @Autowired
    private ApplicationService applicationService;

    @MockBean
    private ApplicationRepository applicationRepository;

    @BeforeEach
    public void init() {
        Application application = new Application("Test1", "Desc", "Pesho");
        Mockito.when(applicationRepository.findAll()).thenReturn(List.of(application));
    }

    @Test
    public void findAllApplication_withoutParameters() {
        List<Application> applications = applicationService.getApplications();
        Assertions.assertEquals("Test1", applications.get(0).getName());
    }
}