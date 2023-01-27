package com.beneti.courseApi.resources;

import com.beneti.courseApi.entities.Course;
import com.beneti.courseApi.entities.dtos.CourseDTO;
import com.beneti.courseApi.entities.dtos.mapper.CourseMapper;
import com.beneti.courseApi.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CourseResource {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseMapper mapper;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findAll() {
        List<Course> list = courseService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/courses")
    public ResponseEntity<Course> create(@Valid @RequestBody CourseDTO courseDTO) throws URISyntaxException {
        Course createdCourse = courseService.create(mapper.mapCourseDTOtoCourse(courseDTO));
        return ResponseEntity.created(new URI("/courses/" + createdCourse.getId())).body(createdCourse);
    }
}
