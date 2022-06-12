package com.pluralsight.springbootgraphql.repository;

import com.pluralsight.springbootgraphql.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
