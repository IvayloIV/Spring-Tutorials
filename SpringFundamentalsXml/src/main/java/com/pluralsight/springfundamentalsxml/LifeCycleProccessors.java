package com.pluralsight.springfundamentalsxml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleProccessors implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Random Bean");
        if (bean instanceof LifeCycleBeanTest) {
            System.out.println("-- PostProcess - Before --");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof LifeCycleBeanTest) {
            System.out.println("-- PostProcess - After --");
        }
        return bean;
    }
}
