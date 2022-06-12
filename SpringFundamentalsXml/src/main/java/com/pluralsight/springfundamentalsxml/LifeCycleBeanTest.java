package com.pluralsight.springfundamentalsxml;

import com.pluralsight.springfundamentalsxml.repository.FruitRepository;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@PropertySource("application.properties")
public class LifeCycleBeanTest implements BeanNameAware, BeanFactoryAware,
        ApplicationContextAware, EnvironmentAware, InitializingBean, DisposableBean {

    @Value("${test}")
    private String test;

    public LifeCycleBeanTest() {
        int t = 3;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("-- BeanFactoryAware --");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("-- BeanNameAware --");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("-- ApplicationContextAware --");
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("-- EnvironmentAware --");
    }

    @PostConstruct
    public void initMethod2() {
        System.out.println("-- PostConstructor --");
    }

    @PreDestroy
    public void destroyMethod2() {
        System.out.println("-- PreDestroy --");
    }

    public void initMethod() {
        System.out.println("-- Xml init method --");
    }

    public void destroyMethod() {
        System.out.println("-- Xml destroy method --");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("-- DisposableBean --");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("-- InitializingBean --");
    }

    @Autowired
    public void setRepository(FruitRepository fruitRepository) {
        System.out.println("-- Fruit repo setter --");
    }

    public void close() {
        System.out.println("-- Close method --");
    }

    public void shutdown() {
        System.out.println("-- ShutDown method --");
    }
}
