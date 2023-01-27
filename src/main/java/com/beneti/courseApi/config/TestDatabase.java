package com.beneti.courseApi.config;

import com.beneti.courseApi.entities.Course;
import com.beneti.courseApi.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "test")
public class TestDatabase implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {
        Course course1Test = new Course("Graduação em TI", "Exatas");
        Course course2Test = new Course("Graduação em Economia", "Exatas");
        Course course3Test = new Course("Graduação em Direito", "Humanas");
        Course course4Test = new Course("Graduação em Psicologia", "Humanas");
        Course course5Test = new Course("Graduação em Medicina", "Biológicas");

        courseRepository.save(course1Test);
        courseRepository.save(course2Test);
        courseRepository.save(course3Test);
        courseRepository.save(course4Test);
        courseRepository.save(course5Test);


    }
}
