package com.pluralsight.springbootswagger.service;

import com.pluralsight.springbootswagger.entity.Application;

import java.util.List;

public interface ApplicationService {

    List<Application> getApplications();

    Application getApplication(Long id);
}
