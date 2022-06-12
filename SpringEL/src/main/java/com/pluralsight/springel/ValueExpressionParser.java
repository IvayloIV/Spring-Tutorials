package com.pluralsight.springel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ValueExpressionParser {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("Hop")
    private String value1;

    @Value("#{'Hop'.length() * 40}")
    private String value2;

    @Value("#{T(java.lang.String).format(T(java.util.Locale).US, 'Test - %.2f', 43.5)}")
    private String value3;

    @Value("#{order.name.substring(2)}")
    private String value4;

    private Integer value5;

    private Integer value6;

    @Value("#{order.price > 20 and 4 > 1}")
    private Boolean value7;

    @Value("#{systemProperties['user.home']}")
    private String value8;

    @Value("#{order.elementsList.?[#this >= 4]}")
    private List<Integer> value9;

    @Value("#{order.elementsMap[order.name]}")
    private Integer value10;

    @Value("#{order.elementsList.?[#this >= 4].size()}")
    private Integer value11;

    @Value("The result of #{'4 + 6'} is equal to #{4 + 6}")
    private String value12;

    public ValueExpressionParser(@Value("#{100}") Integer value6) {
        this.value6 = value6;
    }

    @Bean
    public ApplicationRunner applicationRunner2() {
        return args -> {
            logger.info("--- Start of @Value result ---");
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
            logger.info("--- End of @Value result ---");
        };
    }

    @Value("#{order.price}")
    public void setValue5(Integer value5) {
        this.value5 = value5;
    }
}
