package com.pluralsight.springbootjsp.model;

import com.pluralsight.springbootjsp.constraints.NameLength;

public class Person {

    @NameLength
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
