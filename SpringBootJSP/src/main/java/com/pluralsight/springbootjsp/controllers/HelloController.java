package com.pluralsight.springbootjsp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(ModelMap map) {
        map.put("message", "Hello Ivo!");
        return "greetings";
    }
}
