package com.pluralsight.conferenceapp.repositories;

import com.pluralsight.conferenceapp.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
