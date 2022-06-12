package com.pluralsight.springbootapplication.repositories;

import com.pluralsight.springbootapplication.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
