package com.pluralsight.springfundamentalsjava.repository;


import com.pluralsight.springfundamentalsjava.model.Fruit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomFruitRepository implements FruitRepository {

    @Override
    public List<Fruit> getList() {
        return List.of(new Fruit("Custom1"), new Fruit("Custom2"));
    }
}
