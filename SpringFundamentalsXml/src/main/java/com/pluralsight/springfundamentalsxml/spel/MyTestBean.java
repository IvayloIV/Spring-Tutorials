package com.pluralsight.springfundamentalsxml.spel;

import org.springframework.stereotype.Component;

@Component
public class MyTestBean {

    private String color = "Blue";

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
