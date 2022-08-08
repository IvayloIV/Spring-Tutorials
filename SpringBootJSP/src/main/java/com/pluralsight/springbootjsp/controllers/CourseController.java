package com.pluralsight.springbootjsp.controllers;

import com.pluralsight.springbootjsp.model.Course;
import com.pluralsight.springbootjsp.model.CourseReport;
import com.pluralsight.springbootjsp.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    @ResponseBody
    public List<Course> getCourses() {
        return courseService.getAll();
    }

    @GetMapping("/course-reports")
    @ResponseBody
    public List<CourseReport> getCourseReports() {
        return courseService.getCourseReports();
    }

    @GetMapping("/named/course-reports")
    @ResponseBody
    public List<CourseReport> getNamedCourseReports() {
        return courseService.getNamedCourseReports();
    }
}
