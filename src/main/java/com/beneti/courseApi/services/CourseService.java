package com.beneti.courseApi.services;

import com.beneti.courseApi.entities.Course;

import java.util.List;

public interface CourseService {

    public List<Course> findAll();

    public Course create(Course course);
}
