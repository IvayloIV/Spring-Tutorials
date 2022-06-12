package com.pluralsight.springbootgraphql.repository;

import com.pluralsight.springbootgraphql.entity.Release;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReleaseRepository extends JpaRepository<Release, Long> {
}
