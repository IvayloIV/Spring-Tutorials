package com.pluralsight.springbootswaggergroups.repository;

import com.pluralsight.springbootswaggergroups.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    public List<Application> findAllByNameContains(@Param("name") String name);
}
