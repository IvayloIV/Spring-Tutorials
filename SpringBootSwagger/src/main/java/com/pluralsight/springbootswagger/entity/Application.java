package com.pluralsight.springbootswagger.entity;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "app_name", nullable = false)
    private String name;

    @ApiModelProperty(value = "Description of the application.", required = true)
    @NotNull
    @Column(length = 2000, nullable = false)
    private String description;

    @ApiModelProperty("Owner of the application.")
    private String owner;

    public Application() {
    }

    public Application(String name, String description, String owner) {
        this.name = name;
        this.description = description;
        this.owner = owner;
    }

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
