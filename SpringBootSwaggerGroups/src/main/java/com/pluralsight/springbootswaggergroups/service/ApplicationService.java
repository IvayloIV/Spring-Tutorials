package com.pluralsight.springbootswaggergroups.service;

import com.pluralsight.springbootswaggergroups.entity.Application;

import java.util.List;

public interface ApplicationService {

    List<Application> getApplications();

    Application getApplication(Long id);
}
