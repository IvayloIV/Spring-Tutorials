package com.pluralsight.springfundamentalsjava.service;

import com.pluralsight.springfundamentalsjava.model.Fruit;
import com.pluralsight.springfundamentalsjava.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fruitService")
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class FruitServiceImpl implements FruitService {

    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository customFruitRepository) {
        this.fruitRepository = customFruitRepository;
    }

    @Override
    public List<Fruit> getList() {
        return fruitRepository.getList();
    }

    public void setFruitRepository(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }
}
