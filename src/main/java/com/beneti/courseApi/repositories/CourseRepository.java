package com.beneti.courseApi.repositories;

import com.beneti.courseApi.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByNameContaining(String name);

    List<Course> findByArea(String area);

}
