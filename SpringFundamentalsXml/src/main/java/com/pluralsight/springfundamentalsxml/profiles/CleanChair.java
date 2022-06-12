package com.pluralsight.springfundamentalsxml.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!dev")
public class CleanChair implements Clean {

    @Override
    public void doIt() {
        System.out.println("Chair was cleaned.");
    }
}
