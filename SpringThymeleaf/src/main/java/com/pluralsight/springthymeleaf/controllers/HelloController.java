package com.pluralsight.springthymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping
    public String index() {
        return "redirect:hello";
    }

    @GetMapping("hello")
    public String hello(ModelMap map) {
        map.put("message", "Hello Ivo!");
        return "greetings";
    }
}
