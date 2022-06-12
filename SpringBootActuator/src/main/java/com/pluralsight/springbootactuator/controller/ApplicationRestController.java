package com.pluralsight.springbootactuator.controller;

import com.pluralsight.springbootactuator.entity.Application;
import com.pluralsight.springbootactuator.exception.ApplicationNotFound;
import com.pluralsight.springbootactuator.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/application")
public class ApplicationRestController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationRestController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public ResponseEntity<List<Application>> retrieveList() {
        return ResponseEntity.ok(applicationService.getApplications());
    }

    @GetMapping("{id}")
    public Application retrieveApplication(@PathVariable Long id) {
        try {
            return applicationService.getApplication(id);
        } catch (ApplicationNotFound ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }
}
