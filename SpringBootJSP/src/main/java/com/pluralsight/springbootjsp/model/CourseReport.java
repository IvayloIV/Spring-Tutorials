package com.pluralsight.springbootjsp.model;

public class CourseReport {

    private String name;

    private String description;

    private String personName;

    public CourseReport() {
    }

    public CourseReport(String name, String description, String personName) {
        this.name = name;
        this.description = description;
        this.personName = personName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
