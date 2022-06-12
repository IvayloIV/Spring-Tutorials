package com.pluralsight.springfundamentalsjava;

import com.pluralsight.springfundamentalsjava.service.FruitService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        FruitService fruitService = context.getBean("fruitService", FruitService.class);

        System.out.println(fruitService);
        fruitService.getList().forEach(f -> System.out.println(f.getName()));

        FruitService fruitService2 = context.getBean("fruitService", FruitService.class);
        System.out.println(fruitService2);
    }
}
