package com.pluralsight.springbootgraphql.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "features")
public class CustomEndpointComponent {

    private Map<String, Boolean> features;

    public CustomEndpointComponent() {
        this.features = new HashMap<>();
        this.features.put("application", true);
        this.features.put("release", true);
        this.features.put("ticket", true);
        this.features.put("football", true);
    }

    @ReadOperation
    public Map<String, Boolean> getFeatures() {
        return features;
    }

    @ReadOperation
    public Boolean getFeature(@Selector String feature) {
        return features.get(feature);
    }
}
