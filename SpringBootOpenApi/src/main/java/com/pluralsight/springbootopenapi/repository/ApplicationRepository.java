package com.pluralsight.springbootopenapi.repository;

import com.pluralsight.springbootopenapi.entity.Application;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@SecurityRequirement(name = "applicationapi")
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    public List<Application> findAllByNameContains(@Param("name") String name);
}
