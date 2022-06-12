package com.pluralsight.springbootgraphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pluralsight.springbootgraphql.entity.Application;
import com.pluralsight.springbootgraphql.exception.ApplicationNotFound;
import com.pluralsight.springbootgraphql.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationMutator implements GraphQLMutationResolver {

    private ApplicationRepository applicationRepository;

    @Autowired
    public ApplicationMutator(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application createApplication(String name, String description, String owner) {
        Application newApplication = new Application();
        newApplication.setName(name);
        newApplication.setDescription(description);
        newApplication.setOwner(owner);
        return applicationRepository.save(newApplication);
    }

    public Application updateApplication(Long id, String name) {
        Application application = applicationRepository.findById(id)
            .orElseThrow(() -> new ApplicationNotFound("Application with provided id wasn't found!", id));
        application.setName(name);
        return applicationRepository.save(application);
    }

    public boolean deleteApplication(Long id) {
        try {
            applicationRepository.deleteById(id);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}
