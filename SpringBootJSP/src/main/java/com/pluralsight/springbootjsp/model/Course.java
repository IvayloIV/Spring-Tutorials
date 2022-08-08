package com.pluralsight.springbootjsp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COURSE")
@NamedQueries({
    @NamedQuery(
        name = "CourseReports",
        query = "SELECT new com.pluralsight.springbootjsp.model.CourseReport(c.name, c.description, p.name) " +
        "FROM Course c " +
        "JOIN c.people p")
})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    @JsonManagedReference
    @OneToMany(mappedBy = "course")
    private List<Person> people;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
