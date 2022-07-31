package com.pluralsight.springbootjpa.repositories;

import com.pluralsight.springbootjpa.models.PricingCategory;
import com.pluralsight.springbootjpa.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PricingCategoryJpaRepository extends JpaRepository<PricingCategory, String> {

    List<PricingCategory> findByPricingStartDateAfter(Date startDate);
}
