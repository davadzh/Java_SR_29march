package com.example.java_sr_29m.DTO.TaskDtos;

import com.example.java_sr_29m.DAL.Entities.Category;
import com.example.java_sr_29m.DAL.Entities.User;

import java.util.Date;
import java.util.List;

public class UpdateTaskDto {
    public Long id;
    public String name;
    public String description;
    public Date completionDate;
    public boolean isCompleted;

    public User user;
    public List<Category> categories;
}
