package com.pluralsight.springbootjsp.services;

import com.pluralsight.springbootjsp.model.Course;
import com.pluralsight.springbootjsp.model.CourseReport;
import com.pluralsight.springbootjsp.repositories.CourseJpaRepository;
import com.pluralsight.springbootjsp.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseJpaRepository courseRepository;

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public List<CourseReport> getCourseReports() {
        return courseRepository.getCourseReports();
    }

    @Override
    public List<CourseReport> getNamedCourseReports() {
        return courseRepository.getNamedCourseReports();
    }
}
