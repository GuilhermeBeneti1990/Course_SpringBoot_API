package com.beneti.courseApi;

import com.beneti.courseApi.entities.Course;
import com.beneti.courseApi.services.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseApiApplicationTests {

	@Autowired
	private CourseService courseService;

	@Test
	void contextLoads() {

		List<Course> courses = courseService.findAll();
		System.out.println(courses);

	}

}
