package com.example.java_sr_29m.DAL.Entities;

import com.example.java_sr_29m.DTO.CategoryDtos.CreateCategoryDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Category extends CoreEntity {
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Task> tasks;


    // Constructors

    public Category() {}

    public Category(CreateCategoryDto createCategoryDto) {
        super();
        this.name = createCategoryDto.name;
        this.tasks = createCategoryDto.tasks;
    }


    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
