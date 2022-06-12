package com.pluralsight.springbootactuator.service;

import com.pluralsight.springbootactuator.entity.Application;

import java.util.List;

public interface ApplicationService {

    List<Application> getApplications();

    Application getApplication(Long id);
}
