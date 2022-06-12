package com.pluralsight.springfundamentalsxml.factorybeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CarUsage {

    @Autowired
    private Car car;

    public void test() {
        System.out.println(car.hashCode());
        System.out.println(car.getColor());
    }
}
