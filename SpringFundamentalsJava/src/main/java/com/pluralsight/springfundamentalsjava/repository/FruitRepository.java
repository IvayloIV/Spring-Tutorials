package com.pluralsight.springfundamentalsjava.repository;

import com.pluralsight.springfundamentalsjava.model.Fruit;

import java.util.List;

public interface FruitRepository {
    List<Fruit> getList();
}
