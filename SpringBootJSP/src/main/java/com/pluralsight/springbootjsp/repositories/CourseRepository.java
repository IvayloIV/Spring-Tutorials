package com.pluralsight.springbootjsp.repositories;

import com.pluralsight.springbootjsp.model.Course;
import com.pluralsight.springbootjsp.model.CourseReport;

import java.util.List;

public interface CourseRepository {
    Course save(Course course);

    Course findByName(String name);

    List<Course> findAll();

    List<CourseReport> getCourseReports();

    List<CourseReport> getNamedCourseReports();
}
