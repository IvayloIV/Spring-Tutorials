package com.pluralsight.springbootactuator.actuator;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class InfoApplicationContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("team", "deep shark")
            .withDetail("application-name", "shop")
            .withDetail("contact-us", "ppp@gmail.com")
            .build();
    }
}
