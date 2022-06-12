package com.pluralsight.springaopintroductions;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        Passenger passenger = context.getBean(Passenger.class);

        AspectJProxyFactory factory = new AspectJProxyFactory(passenger);
        factory.addAspect(new PassengerAdvisor());
        factory.setOptimize(true);

        Passenger proxyPassenger = factory.getProxy();
        System.out.println(proxyPassenger.getClass().getName());
        System.out.println(proxyPassenger instanceof Passenger);
        System.out.println(proxyPassenger instanceof PassengerDao);

        ((PassengerDao) proxyPassenger).insertRecord("Tosho");
        Passenger tosho = ((PassengerDao) proxyPassenger).getById(1L);
        System.out.println(tosho);
    }
}
