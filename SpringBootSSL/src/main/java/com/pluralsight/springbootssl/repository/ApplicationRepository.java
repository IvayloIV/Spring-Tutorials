package com.pluralsight.springbootssl.repository;

import com.pluralsight.springbootssl.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
