package com.pluralsight.springbootactuator.actuator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

@Component
public class HeapHealthIndicator implements HealthIndicator {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Health health() {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        long used = memoryMXBean.getHeapMemoryUsage().getUsed();
        logger.info("Used memory: {}", used);
        Status status = used < 1_000_000_000 ? Status.UP : Status.DOWN;
        return Health.status(status).build();
    }
}
