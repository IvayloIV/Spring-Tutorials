package com.pluralsight.springboottesting.repository;

import com.pluralsight.springboottesting.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReleaseRepository extends JpaRepository<Release, Long> {
}
