package com.pluralsight.springfundamentalsxml.repository;

import com.pluralsight.springfundamentalsxml.model.Fruit;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class HibernateFruitRepository implements FruitRepository {

    @PostConstruct
    public void init() {
        System.out.println("Hello from init!");
    }

    @Override
    public List<Fruit> getList() {
        return List.of(new Fruit("Banana"), new Fruit("Apple"));
    }
}
