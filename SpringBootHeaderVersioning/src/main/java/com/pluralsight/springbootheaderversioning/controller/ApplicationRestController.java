package com.pluralsight.springbootheaderversioning.controller;

import com.pluralsight.springbootheaderversioning.entity.Application;
import com.pluralsight.springbootheaderversioning.exception.ApplicationNotFound;
import com.pluralsight.springbootheaderversioning.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ApplicationRestController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationRestController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping(value = "/application", headers = "Accept-version=v1")
    public ResponseEntity<List<Application>> retrieveListV1() {
        return ResponseEntity.ok(applicationService.getApplications());
    }

    @GetMapping(value = "/application", headers = "Accept-version=v2")
    public ResponseEntity<List<Application>> retrieveListV2() {
        return ResponseEntity.ok(List.of(new Application("Library", "506 books", "Petar")));
    }
}
