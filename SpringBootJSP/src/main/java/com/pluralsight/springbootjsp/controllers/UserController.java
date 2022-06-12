package com.pluralsight.springbootjsp.controllers;

import com.pluralsight.springbootjsp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/user")
    public User getUser(@RequestParam(name = "name", defaultValue = "Ivo") String name,
                        @RequestParam(name = "age", defaultValue = "25") Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    @PostMapping("/user")
    public User postUser(@RequestBody User user) {
        logger.info("User name: {}", user.getName());
        return user;
    }
}
