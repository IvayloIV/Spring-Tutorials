package com.pluralsight.helloworldstarter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(Hello.class)
public class HelloConfiguration {

    @Value("${hello.name:Gosho}")
    private String name;

    @Bean
    @ConditionalOnMissingBean
    public Hello hello() {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
}
