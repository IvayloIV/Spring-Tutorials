package com.pluralsight.springfundamentalsxml;

import com.pluralsight.springfundamentalsxml.factorybeans.CarUsage;
import com.pluralsight.springfundamentalsxml.profiles.Clean;
import com.pluralsight.springfundamentalsxml.proxies.DobAdvice;
import com.pluralsight.springfundamentalsxml.proxies.Dog;
import com.pluralsight.springfundamentalsxml.proxies.DogImpl;
import com.pluralsight.springfundamentalsxml.service.FruitService;
import com.pluralsight.springfundamentalsxml.spel.TestSpEl;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        FruitService fruitService = context.getBean(FruitService.class);

        System.out.println(fruitService);
        fruitService.getList().forEach(f -> System.out.println(f.getName()));

        System.out.println("-- Xml Finished --");

        AbstractApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);
        CarUsage carUsage = context2.getBean(CarUsage.class);
        carUsage.test();

        CarUsage carUsage2 = context2.getBean(CarUsage.class);
        carUsage2.test();

        TestSpEl bean = context2.getBean(TestSpEl.class);
        System.out.println(bean.getTestBean());

        ProxyFactory proxyFactory = new ProxyFactory(new DogImpl());
        proxyFactory.setInterfaces(Dog.class);
        proxyFactory.addAdvice(new DobAdvice());

        Dog proxy = (Dog) proxyFactory.getProxy();
        System.out.println(proxy.getClass());
        proxy.bark();

        Clean clean = context2.getBean(Clean.class);
        clean.doIt();

        context2.close();
    }
}
