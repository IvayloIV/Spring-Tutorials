package com.pluralsight.springbootswaggergroups.controller;

import com.pluralsight.springbootswaggergroups.entity.Application;
import com.pluralsight.springbootswaggergroups.exception.ApplicationNotFound;
import com.pluralsight.springbootswaggergroups.service.ApplicationService;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/api/v2/application")
public class ApplicationV2RestController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationV2RestController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public ResponseEntity<List<Application>> retrieveList() {
        return ResponseEntity.ok(applicationService.getApplications());
    }
}
