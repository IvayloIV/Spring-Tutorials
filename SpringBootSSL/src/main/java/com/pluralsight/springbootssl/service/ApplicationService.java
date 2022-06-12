package com.pluralsight.springbootssl.service;


import com.pluralsight.springbootssl.entity.Application;

import java.util.List;

public interface ApplicationService {

    List<Application> getApplications();

    Application getApplication(Long id);
}
