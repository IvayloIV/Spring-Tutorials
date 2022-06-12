package com.pluralsight.springaopintroductions;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.support.DefaultIntroductionAdvisor;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PassengerAdvisor extends DefaultIntroductionAdvisor {

    public PassengerAdvisor() {
        super(new PassengerDaoImpl());
    }
}
