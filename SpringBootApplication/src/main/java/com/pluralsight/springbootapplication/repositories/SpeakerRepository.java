package com.pluralsight.springbootapplication.repositories;

import com.pluralsight.springbootapplication.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
