package com.pluralsight.springbootactuator.actuator;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Endpoint(id = "name")
public class CustomNameEndpoint {

    private Map<String, String> names = new HashMap<>(Map.of("name", "Ivan"));

    //GET request
    @ReadOperation
    public Map<String, String> getNames() {
        return names;
    }

    //POST request with {"newName": "Tosho"}
    @WriteOperation
    public Map<String, String> updateNames(String newName) {
        names.put("name", newName);
        return names;
    }

    //DELETE request with ?name=Ivan
    @DeleteOperation
    public Map<String, String> deleteName(String name) {
        names.remove("name", name);
        return names;
    }
}
