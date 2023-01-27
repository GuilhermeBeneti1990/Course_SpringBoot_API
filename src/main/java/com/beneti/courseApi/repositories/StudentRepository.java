package com.beneti.courseApi.repositories;

import com.beneti.courseApi.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
