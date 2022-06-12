package com.pluralsight.springboottesting.repository;

import com.pluralsight.springboottesting.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
