package com.pluralsight.springaopannotations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(2)
public class LogAspect {

    @Before("execution(* *.*Id(..))")
    public void logBefore() {
        System.out.println("Before method execution.");
    }

    @After("execution(* *.*Id(..))")
    public void logAfter() {
        System.out.println("After method execution.");
    }

    @Around("execution(* *.*Id(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before around " + joinPoint.getSignature());
        System.out.println("Before around " + Arrays.toString(joinPoint.getArgs()));
        Object proceed = joinPoint.proceed();
        System.out.println("After around " + proceed);
        return proceed;
    }

    @AfterThrowing(pointcut = "@annotation(com.pluralsight.springaopannotations.LogException)", throwing = "ex")
    public void logException(PassengerNotFound ex) {
        System.out.println("Logger: " + ex.getMessage());
    }
}
