package com.pluralsight.springbootjsp.controllers;

import com.pluralsight.springbootjsp.model.Person;
import com.pluralsight.springbootjsp.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class RegistrationController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Validator validator;

    @Autowired
    private PersonService personService;

    @ModelAttribute
    public void addPersonAttr(ModelMap modelMap) {
        modelMap.put("person", new Person());
    }

    @GetMapping("registration")
    public String getRegistrationForm() {
        return "registration";
    }

    @PostMapping("registration")
    public String addPerson(@Valid @ModelAttribute("person") Person person,
                            BindingResult bindingResult) {
        Set<ConstraintViolation<Person>> validate = validator.validate(person);
        logger.info(String.valueOf(validate.isEmpty()));

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        personService.addPerson(person);
        logger.info(person.getName());
        return "redirect:registration";
    }

    @PutMapping("registration")
    @ResponseBody
    public Person updatePerson(@Valid @ModelAttribute("person") Person person,
                            BindingResult bindingResult) {
        logger.info(String.valueOf(bindingResult.hasErrors()));
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        return personService.addPerson(person);
    }
}
