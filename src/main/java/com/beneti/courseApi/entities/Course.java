package com.beneti.courseApi.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "college_courses")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    public Course() {
        this.courseValue = new BigDecimal(0);
    }

    public Course(String name, String area) {
        this.name = name;
        this.area = area;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "course_name", nullable = false)
    private String name;
    @Column(nullable = false)
    private String area;

    @Column(name = "creation_date")
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @Column(name = "update_date")
    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    @NotNull(message = "User cannot be null")
    @NotBlank(message = "User cannot be empty")
    private String user_creation;

    @Transient
    private BigDecimal courseValue;


    @PostPersist
    private void postPersistData() {
        this.name = this.name + "_createdByPostmanTest";
    }

    @PrePersist
    private void beforePersistData() {
        this.user_creation = "Admin";
    }

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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUser_creation() {
        return user_creation;
    }

    public void setUser_creation(String user_creation) {
        this.user_creation = user_creation;
    }

    public BigDecimal getCourseValue() {
        return courseValue;
    }

    public void setCourseValue(BigDecimal courseValue) {
        this.courseValue = courseValue;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}
