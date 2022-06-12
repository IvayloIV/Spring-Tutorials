package com.pluralsight.springaopannotations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class TimeAspect {

    private final Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("within(com.pluralsight.springaopannotations.PassengerDaoImpl)")
    public void allLogMethods() {
    }

    @AfterReturning(value = "allLogMethods()", returning = "value")
    public void logAfterReturnResult(JoinPoint joinPoint, Object value) {
        logger.info("After returning call: " + value);
        logger.info(joinPoint.getTarget().toString());
        logger.info(joinPoint.toString());
    }
}
