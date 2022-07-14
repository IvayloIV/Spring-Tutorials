package com.pluralsight.springbooturlversioning.service;

import com.pluralsight.springbooturlversioning.entity.Application;

import java.util.List;

public interface ApplicationService {

    List<Application> getApplications();

    Application getApplication(Long id);
}
