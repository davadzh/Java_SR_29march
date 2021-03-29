package com.example.java_sr_29m.DAL.Entities;

import com.example.java_sr_29m.DTO.TaskDtos.CreateTaskDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Task extends CoreEntity {
    private String name;
    private String description;
    private Date completionDate;
    private boolean isCompleted;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Category> categories;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;


    // Constructors

    public Task() {}

    public Task(CreateTaskDto createTaskDto) {
        super();
        this.name = createTaskDto.name;
        this.description = createTaskDto.description;
        this.completionDate = createTaskDto.completionDate;
        this.isCompleted = false;
        this.categories = createTaskDto.categories;
        this.user = createTaskDto.user;
    }


    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Date completionDate) {
        this.completionDate = completionDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
