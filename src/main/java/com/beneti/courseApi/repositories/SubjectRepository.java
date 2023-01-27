package com.beneti.courseApi.repositories;

import com.beneti.courseApi.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
