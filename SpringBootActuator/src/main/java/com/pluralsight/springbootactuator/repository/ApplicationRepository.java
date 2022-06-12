package com.pluralsight.springbootactuator.repository;

import com.pluralsight.springbootactuator.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
