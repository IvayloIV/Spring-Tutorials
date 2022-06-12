package com.pluralsight.springfundamentalsxml.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestSpEl {

    @Value("#{4 + 5}")
    private Integer sum;

    @Value("#{${test} + T(java.lang.Math).random()}")
    private Double randomNum;

    @Value("#{myTestBean.getColor() + ' is my favourite!'}")
    private String testBean;

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Double getRandomNum() {
        return randomNum;
    }

    public void setRandomNum(Double randomNum) {
        this.randomNum = randomNum;
    }

    public String getTestBean() {
        return testBean;
    }

    public void setTestBean(String testBean) {
        this.testBean = testBean;
    }
}
