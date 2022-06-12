package com.pluralsight.springel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class XmlAppExpressionParser {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private String value1;
    private String value2;
    private String value3;
    private String value4;
    private Integer value5;
    private Integer value6;
    private Boolean value7;
    private String value8;
    private List<Integer> value9;
    private Integer value10;
    private Integer value11;
    private String value12;

    public XmlAppExpressionParser(Integer value6) {
        this.value6 = value6;
    }

    public void initMethod() {
        logger.info("--- Start of xml result ---");
        logger.info(value1);
        logger.info(value2);
        logger.info(value3);
        logger.info(value4);
        logger.info(value5.toString());
        logger.info(value6.toString());
        logger.info(value7.toString());
        logger.info(value8);
        logger.info(value9.toString());
        logger.info(value10.toString());
        logger.info(value11.toString());
        logger.info(value12);
        logger.info("--- End of xml result ---");
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    public String getValue4() {
        return value4;
    }

    public void setValue4(String value4) {
        this.value4 = value4;
    }

    public Integer getValue5() {
        return value5;
    }

    public void setValue5(Integer value5) {
        this.value5 = value5;
    }

    public Integer getValue6() {
        return value6;
    }

    public void setValue6(Integer value6) {
        this.value6 = value6;
    }

    public Boolean getValue7() {
        return value7;
    }

    public void setValue7(Boolean value7) {
        this.value7 = value7;
    }

    public String getValue8() {
        return value8;
    }

    public void setValue8(String value8) {
        this.value8 = value8;
    }

    public List<Integer> getValue9() {
        return value9;
    }

    public void setValue9(List<Integer> value9) {
        this.value9 = value9;
    }

    public Integer getValue10() {
        return value10;
    }

    public void setValue10(Integer value10) {
        this.value10 = value10;
    }

    public Integer getValue11() {
        return value11;
    }

    public void setValue11(Integer value11) {
        this.value11 = value11;
    }

    public String getValue12() {
        return value12;
    }

    public void setValue12(String value12) {
        this.value12 = value12;
    }
}
