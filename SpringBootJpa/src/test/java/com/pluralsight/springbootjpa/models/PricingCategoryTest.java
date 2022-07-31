package com.pluralsight.springbootjpa.models;

import com.pluralsight.springbootjpa.repositories.PricingCategoryJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PricingCategoryTest {
    @Autowired
    private PricingCategoryJpaRepository repository;

    @Test
    public void testJpaAfter() {
        Date date = new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime();
        List<PricingCategory> pricingCategories = repository.findByPricingStartDateAfter(date);
        assertEquals(2, pricingCategories.size());
    }

}
