package com.pluralsight.springbootjsp.repositories;

import com.pluralsight.springbootjsp.model.Course;
import com.pluralsight.springbootjsp.model.CourseReport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Course save(Course course) {
        entityManager.persist(course);
        return course;
    }

    @Override
    public Course findByName(String name) {
        TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c " +
                "WHERE c.name like :name", Course.class);

        query.setParameter("name", "%" + name + "%");
        return query.getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Course> findAll() {
        TypedQuery<Course> query = entityManager.createQuery("SELECT c FROM Course c", Course.class);
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public List<CourseReport> getCourseReports() {
        TypedQuery<CourseReport> query = entityManager.createQuery(
         "SELECT new com.pluralsight.springbootjsp.model.CourseReport(c.name, c.description, p.name) " +
                "FROM Course c " +
                "JOIN c.people p", CourseReport.class);
        return query.getResultList();
    }

    @Override
    public List<CourseReport> getNamedCourseReports() {
        TypedQuery<CourseReport> query = entityManager.createNamedQuery("CourseReports", CourseReport.class);
        return query.getResultList();
    }
}
