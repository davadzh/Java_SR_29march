package com.example.java_sr_29m.BLL.Services.CategoryService;

import com.example.java_sr_29m.DAL.Entities.Category;
import com.example.java_sr_29m.DAL.Entities.Task;
import com.example.java_sr_29m.DTO.CategoryDtos.CreateCategoryDto;
import com.example.java_sr_29m.DTO.CategoryDtos.UpdateCategoryDto;
import com.example.java_sr_29m.DTO.TaskDtos.CreateTaskDto;
import com.example.java_sr_29m.DTO.TaskDtos.UpdateTaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {
    List<Category> getCategories();
    String addCategory(CreateCategoryDto createCategoryDto);
    String updateCategory(UpdateCategoryDto updateCategoryDto);
    String deleteCategoryById(Long id);
}
