package com.pluralsight.springbootjsp.services;

import com.pluralsight.springbootjsp.model.Course;
import com.pluralsight.springbootjsp.model.Person;
import com.pluralsight.springbootjsp.repositories.CourseJpaRepository;
import com.pluralsight.springbootjsp.repositories.CourseRepository;
import com.pluralsight.springbootjsp.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CourseJpaRepository courseRepository;

    @Override
    @Transactional
    public Person addPerson(Person person) {
        if (person.getId() == null) {
            String name = "Java Introduction";
            Course course = courseRepository.findByNameContaining(name);

            if (course == null) {
                course = new Course();
                course.setName(name);
                course.setDescription("Java course for beginners.");
            }
            person.setCourse(course);
        } else {
            Person savedPerson = personRepository.findById(person.getId());
            savedPerson.setName(person.getName());
            person = savedPerson;
        }

        return personRepository.save(person);
    }
}
