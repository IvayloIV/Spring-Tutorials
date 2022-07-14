package com.pluralsight.springbooturlversioning.controller;

import com.pluralsight.springbooturlversioning.entity.Application;
import com.pluralsight.springbooturlversioning.exception.ApplicationNotFound;
import com.pluralsight.springbooturlversioning.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@BasePathAwareController
public class ApplicationRestController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationRestController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/application")
    public ResponseEntity<List<Application>> retrieveList() {
        return ResponseEntity.ok(applicationService.getApplications());
    }

    @GetMapping("/application/{id}")
    public Application retrieveApplication(@PathVariable Long id) {
        try {
            return applicationService.getApplication(id);
        } catch (ApplicationNotFound ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
}
