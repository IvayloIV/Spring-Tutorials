package com.pluralsight.springfundamentalsxml.repository;

import com.pluralsight.springfundamentalsxml.model.Fruit;

import java.util.List;

public class CustomFruitRepository implements FruitRepository {

    @Override
    public List<Fruit> getList() {
        return List.of(new Fruit("Custom1"), new Fruit("Custom2"));
    }
}
