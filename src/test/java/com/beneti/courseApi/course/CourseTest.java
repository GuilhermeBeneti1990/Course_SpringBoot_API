package com.beneti.courseApi.course;

import com.beneti.courseApi.entities.Course;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CourseTest {

    Course course;

    @BeforeAll
    void initialize() {
        System.out.println("Inicializando classe de teste: CourseTest...");
    }

    @BeforeEach
    void initializeCourse() {
        course = new Course();
    }

    @AfterAll
    void finishing() {
        System.out.println("Finalizando classe de teste: CourseTest");
    }

    @Test
    void test() {

    }

    @Test
    void coursesListNotEmptyTest() {
        assertNotNull(course);
    }

    @Test
    void courseValueNotNull() {
        assertNotNull(course.getCourseValue());
    }

    @Test
    void newCourseZeroValueTest() {
        assertEquals(new BigDecimal(0), course.getCourseValue());
    }

    @Test
    void newCourseWithoutStudents() {
        assertTrue(course.getStudents().isEmpty());
    }

}
