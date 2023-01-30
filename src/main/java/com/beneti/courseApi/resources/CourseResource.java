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
@RequestMapping("/api/courses")
public class CourseResource {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseMapper mapper;

    @GetMapping
    public ResponseEntity<List<Course>> findAll() {
        List<Course> list = courseService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Integer id) {
        Course course = courseService.findById(id);
        return ResponseEntity.ok().body(course);
    }

    @GetMapping("/name")
    public ResponseEntity<List<Course>> findByName(@RequestParam String name) {
        List<Course> courses = courseService.findByName(name);
        return ResponseEntity.ok().body(courses);
    }

    @GetMapping("/area")
    public ResponseEntity<List<Course>> findByArea(@RequestParam String area) {
        List<Course> courses = courseService.findByArea(area);
        return ResponseEntity.ok().body(courses);
    }

    @PostMapping
    public ResponseEntity<Course> create(@Valid @RequestBody CourseDTO courseDTO) throws URISyntaxException {
        Course createdCourse = courseService.create(mapper.mapCourseDTOtoCourse(courseDTO));
        return ResponseEntity.created(new URI("/courses/" + createdCourse.getId())).body(createdCourse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@Valid @RequestBody CourseDTO courseDTO, @PathVariable Integer id)
            throws URISyntaxException {
        Course updatedCourse = mapper.mapCourseDTOtoCourse(courseDTO);
        updatedCourse.setId(id);
        courseService.update(updatedCourse);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id)
            throws URISyntaxException {
        courseService.delete(id);
        return ResponseEntity.noContent().build();
        
    }
}
