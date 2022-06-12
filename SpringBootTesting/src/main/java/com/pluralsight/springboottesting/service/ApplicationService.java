package com.pluralsight.springboottesting.service;

import com.pluralsight.springboottesting.entity.Application;

import java.util.List;

public interface ApplicationService {

    List<Application> getApplications();

    Application getApplication(Long id);
}
