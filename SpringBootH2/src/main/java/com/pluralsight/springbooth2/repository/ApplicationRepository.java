package com.pluralsight.springbooth2.repository;

import com.pluralsight.springbooth2.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
