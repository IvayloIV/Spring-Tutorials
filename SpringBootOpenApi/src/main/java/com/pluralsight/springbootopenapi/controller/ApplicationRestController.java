package com.pluralsight.springbootopenapi.controller;

import com.pluralsight.springbootopenapi.entity.Application;
import com.pluralsight.springbootopenapi.exception.ApplicationNotFound;
import com.pluralsight.springbootopenapi.service.ApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@SecurityRequirement(name = "applicationapi")
@Tag(name = "Applications API", description = "API for applications information")
public class ApplicationRestController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationRestController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @Operation(summary = "Get all available applications.")
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
