package com.beneti.courseApi.services.impl;

import com.beneti.courseApi.entities.Course;
import com.beneti.courseApi.repositories.CourseRepository;
import com.beneti.courseApi.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course create(Course course) {
        return courseRepository.save(course);
    }
}
