package com.beneti.courseApi.entities.dtos.mapper;

import com.beneti.courseApi.entities.Course;
import com.beneti.courseApi.entities.dtos.CourseDTO;
import org.springframework.stereotype.Service;

@Service
public class CourseMapper {

    public Course mapCourseDTOtoCourse(CourseDTO dto) {
        Course course = new Course(dto.getName(), dto.getArea());
        return course;
    }

}
