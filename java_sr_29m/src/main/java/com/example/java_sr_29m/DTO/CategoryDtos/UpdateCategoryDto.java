package com.example.java_sr_29m.DTO.CategoryDtos;

import com.example.java_sr_29m.DAL.Entities.Task;

import java.util.List;

public class UpdateCategoryDto {
    public Long id;
    public String name;

    public List<Task> tasks;
}
