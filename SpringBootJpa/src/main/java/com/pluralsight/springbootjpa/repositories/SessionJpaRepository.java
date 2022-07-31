package com.pluralsight.springbootjpa.repositories;

import com.pluralsight.springbootjpa.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionJpaRepository extends JpaRepository<Session, Long> {

    List<Session> findBySessionNameContains(String name);

    Session findFirstBySessionNameContains(String name);
}
