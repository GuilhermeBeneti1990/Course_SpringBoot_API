package com.beneti.courseApi.services;

import com.beneti.courseApi.entities.Course;

import java.util.List;

public interface CourseService {

    public List<Course> findAll();

    public Course findById(Integer id);

    public List<Course> findByName(String name);

    public List<Course> findByArea(String area);

    public Course create(Course course);

    public void update(Course course);

    public void delete(Integer id);
}
