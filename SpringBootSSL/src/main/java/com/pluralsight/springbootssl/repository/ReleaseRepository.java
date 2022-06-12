package com.pluralsight.springbootssl.repository;

import com.pluralsight.springbootssl.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReleaseRepository extends JpaRepository<Release, Long> {
}
