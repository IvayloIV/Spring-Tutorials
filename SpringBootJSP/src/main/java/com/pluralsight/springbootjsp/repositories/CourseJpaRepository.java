package com.pluralsight.springbootjsp.repositories;

import com.pluralsight.springbootjsp.model.Course;
import com.pluralsight.springbootjsp.model.CourseReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseJpaRepository extends JpaRepository<Course, Long> {

    Course findByNameContaining(String name);

    @Query("SELECT new com.pluralsight.springbootjsp.model.CourseReport(c.name, c.description, p.name) " +
            "FROM Course c " +
            "JOIN c.people p")
    List<CourseReport> getCourseReports();

    @Query(name = "CourseReports")
    List<CourseReport> getNamedCourseReports();
}
