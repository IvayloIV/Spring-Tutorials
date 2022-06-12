package com.pluralsight.springboottesting.service;

import com.pluralsight.springboottesting.entity.Application;
import com.pluralsight.springboottesting.exception.ApplicationNotFound;
import com.pluralsight.springboottesting.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public List<Application> getApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public Application getApplication(Long id) {
        return applicationRepository.findById(id)
            .orElseThrow(() -> new ApplicationNotFound("Incorrect application id!"));
    }
}
