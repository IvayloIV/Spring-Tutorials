package com.pluralsight.springbootjsp.services;

import com.pluralsight.springbootjsp.model.Course;
import com.pluralsight.springbootjsp.model.CourseReport;

import java.util.List;

public interface CourseService {
    List<Course> getAll();

    List<CourseReport> getCourseReports();

    List<CourseReport> getNamedCourseReports();
}
