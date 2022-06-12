package com.pluralsight.springbootactuator.actuator;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class TimeMetricsRequest {

    private Timer timer;

    @Autowired
    public TimeMetricsRequest(MeterRegistry meterRegistry) {
        this.timer = meterRegistry.timer("long.operation");
    }

    @PostConstruct
    public void init() {
        applicationRunner();
        applicationRunner();
        applicationRunner();
    }

    public void applicationRunner() {
        timer.record(() -> {
            try {
                Thread.sleep(3333);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
