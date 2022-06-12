package com.pluralsight.springbootgraphql.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ArmyHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.down().withDetail("ArmyService", "out of guns").build();
    }
}
