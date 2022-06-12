package com.pluralsight.springfundamentalsxml.service;

import com.pluralsight.springfundamentalsxml.model.Fruit;
import com.pluralsight.springfundamentalsxml.repository.FruitRepository;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.List;

public class FruitServiceImpl implements FruitService, BeanNameAware {

    private FruitRepository fruitRepository;

    public FruitServiceImpl() {
    }

    public FruitServiceImpl(FruitRepository fruitRepository2) {
        this.fruitRepository = fruitRepository2;
    }

    @Override
    public List<Fruit> getList() {
        return fruitRepository.getList();
    }

    public void setFruitRepository2(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println(name);
    }
}
