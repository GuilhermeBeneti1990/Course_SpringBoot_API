package com.beneti.courseApi.services.impl;

import com.beneti.courseApi.entities.Course;
import com.beneti.courseApi.repositories.CourseRepository;
import com.beneti.courseApi.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Integer id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.orElse(null);
    }

    @Override
    public List<Course> findByName(String name) {
        return courseRepository.findByNameContaining(name);
    }

    @Override
    public List<Course> findByArea(String area) {
        return courseRepository.findByArea(area);
    }

    @Override
    public Course create(Course course) {
        course.setId(null);
        return courseRepository.save(course);
    }

    @Override
    public void update(Course course) {
        Course currentCourse = this.findById(course.getId());
        currentCourse.setName(course.getName());
        currentCourse.setArea(course.getArea());
        courseRepository.save(currentCourse);
    }

    @Override
    public void delete(Integer id) {
        courseRepository.deleteById(id);
    }
}
