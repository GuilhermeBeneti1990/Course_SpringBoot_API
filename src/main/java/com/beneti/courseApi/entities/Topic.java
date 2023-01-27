package com.beneti.courseApi.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "topics")
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;

    public Topic() {
    }

    public Topic(String name, Set<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "subjects_topics", joinColumns = {
            @JoinColumn(name = "topic_id", referencedColumnName = "id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "subject_id", referencedColumnName = "id")
    })
    private Set<Subject> subjects = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}
