package com.pluralsight.springbooth2.repository;

import com.pluralsight.springbooth2.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReleaseRepository extends JpaRepository<Release, Long> {
}
