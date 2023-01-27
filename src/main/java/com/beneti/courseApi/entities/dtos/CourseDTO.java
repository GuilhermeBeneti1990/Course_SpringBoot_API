package com.beneti.courseApi.entities.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CourseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public CourseDTO() {
    }

    public CourseDTO(Integer id, String name, String area) {
        this.id = id;
        this.name = name;
        this.area = area;
    }

    private Integer id;
    @NotNull
    @NotBlank
    @NotEmpty(message = "Name cannot be empty!")
    @Size(min = 5, max = 20)
    private String name;
    @NotBlank
    @Size(min = 5, max = 10)
    private String area;

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
}
