package com.pluralsight.springbootopenapi.service;

import com.pluralsight.springbootopenapi.entity.Application;

import java.util.List;

public interface ApplicationService {

    List<Application> getApplications();

    Application getApplication(Long id);
}
