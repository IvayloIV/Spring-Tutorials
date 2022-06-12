package com.pluralsight.springel;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class Order {

    private String name = "Ivan";
    private Integer price = 40;
    private List<Integer> elementsList = List.of(3, 4, 5, 2);
    private Map<String, Integer> elementsMap = Map.of("Misho", 43, "Ivan", 13);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<Integer> getElementsList() {
        return elementsList;
    }

    public void setElementsList(List<Integer> elementsList) {
        this.elementsList = elementsList;
    }

    public Map<String, Integer> getElementsMap() {
        return elementsMap;
    }

    public void setElementsMap(Map<String, Integer> elementsMap) {
        this.elementsMap = elementsMap;
    }
}
