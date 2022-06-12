package com.pluralsight.springbootgraphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pluralsight.springbootgraphql.entity.Application;
import com.pluralsight.springbootgraphql.exception.ApplicationNotFound;
import com.pluralsight.springbootgraphql.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationResolver implements GraphQLQueryResolver {

    private ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationResolver(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public List<Application> getApplications() {
        return applicationRepository.findAll();
    }

    public Application getApplication(Long id) {
        return applicationRepository.findById(id)
            .orElseThrow(() -> new ApplicationNotFound("Application with provided id wasn't found!", id));
    }
}
