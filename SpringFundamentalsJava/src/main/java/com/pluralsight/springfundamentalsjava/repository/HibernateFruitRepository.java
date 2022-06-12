package com.pluralsight.springfundamentalsjava.repository;

import com.pluralsight.springfundamentalsjava.model.Fruit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateFruitRepository implements FruitRepository {

    @Override
    public List<Fruit> getList() {
        return List.of(new Fruit("Banana"), new Fruit("Apple"));
    }
}
