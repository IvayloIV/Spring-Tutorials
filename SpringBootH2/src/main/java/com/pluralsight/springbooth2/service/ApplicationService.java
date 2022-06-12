package com.pluralsight.springbooth2.service;

import com.pluralsight.springbooth2.entity.Application;

import java.util.List;

public interface ApplicationService {

    List<Application> getApplications();

    Application getApplication(Long id);
}
