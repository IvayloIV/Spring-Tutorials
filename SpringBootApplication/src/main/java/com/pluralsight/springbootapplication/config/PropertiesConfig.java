package com.pluralsight.springbootapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@ConfigurationProperties(prefix = "app")
public class PropertiesConfig {

//    @Value("${app.version}")
//    private String version;

//    @Autowired
//    private Environment environment;

    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
