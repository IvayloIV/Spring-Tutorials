package com.pluralsight.springbootheaderversioning.service;

import com.pluralsight.springbootheaderversioning.entity.Application;

import java.util.List;

public interface ApplicationService {

    List<Application> getApplications();

    Application getApplication(Long id);
}
