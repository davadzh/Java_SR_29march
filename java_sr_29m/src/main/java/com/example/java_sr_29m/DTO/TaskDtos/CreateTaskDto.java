package com.example.java_sr_29m.DTO.TaskDtos;

import com.example.java_sr_29m.DAL.Entities.Category;
import com.example.java_sr_29m.DAL.Entities.User;

import java.util.Date;
import java.util.List;

public class CreateTaskDto {
    public String name;
    public String description;
    public Date completionDate;

    public User user;
    public List<Category> categories;
}
