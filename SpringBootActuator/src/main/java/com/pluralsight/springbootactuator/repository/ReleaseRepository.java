package com.pluralsight.springbootactuator.repository;

import com.pluralsight.springbootactuator.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReleaseRepository extends JpaRepository<Release, Long> {
}
