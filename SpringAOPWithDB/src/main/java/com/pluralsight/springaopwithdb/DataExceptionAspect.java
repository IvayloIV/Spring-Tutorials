package com.pluralsight.springaopwithdb;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataExceptionAspect {

    @AfterThrowing(pointcut = "execution(public * *.getById(..))", throwing = "ex")
    public void catchEmptyResult(EmptyResultDataAccessException ex) {
        System.out.println("Exception for invalid passenger! Message: " + ex.getMessage());
    }
}
