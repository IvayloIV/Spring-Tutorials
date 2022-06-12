package com.pluralsight.springfundamentalsxml.repository;

import com.pluralsight.springfundamentalsxml.model.Fruit;

import java.util.List;

public interface FruitRepository {
    List<Fruit> getList();
}
