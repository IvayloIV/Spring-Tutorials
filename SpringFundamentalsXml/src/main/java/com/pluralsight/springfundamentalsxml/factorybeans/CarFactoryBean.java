package com.pluralsight.springfundamentalsxml.factorybeans;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

//@Component
public class CarFactoryBean implements FactoryBean<Car> {

    private static int a = 0;

    @Override
    public Car getObject() throws Exception {
        if (a++ == 0) {
            return new Car("Blue");
        } else {
            return new Car("Red");
        }
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
