package com.beneti.courseApi.repositories;

import com.beneti.courseApi.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
}
