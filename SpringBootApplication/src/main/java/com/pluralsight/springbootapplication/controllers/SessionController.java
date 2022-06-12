package com.pluralsight.springbootapplication.controllers;

import com.pluralsight.springbootapplication.models.Session;
import com.pluralsight.springbootapplication.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/session")
public class SessionController {

    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> getSessions() {
        return sessionRepository.findAll();
    }

    @GetMapping("{id}")
    public Session getSession(@PathVariable Long id) {
        return sessionRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session create(@RequestBody Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    @PutMapping("{id}")
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        Session oldSession = sessionRepository.getById(id);
        BeanUtils.copyProperties(session, oldSession, "id");
        return sessionRepository.saveAndFlush(oldSession);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        sessionRepository.deleteById(id);
    }
}
