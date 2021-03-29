package com.example.java_sr_29m.BLL.Services.CategoryService;

import com.example.java_sr_29m.DAL.Entities.Category;
import com.example.java_sr_29m.DAL.Repositories.CategoryRepo;
import com.example.java_sr_29m.DTO.CategoryDtos.CreateCategoryDto;
import com.example.java_sr_29m.DTO.CategoryDtos.UpdateCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public String addCategory(CreateCategoryDto createCategoryDto) {
        Category newCategory = new Category(createCategoryDto);
        categoryRepo.save(newCategory);

        return "Новая категория успешно создана";
    }

    @Override
    public String updateCategory(UpdateCategoryDto updateCategoryDto) {
        Optional<Category> candidate = categoryRepo.findById(updateCategoryDto.id);

        if (candidate.isEmpty())
            throw new RuntimeException();

        Category category = candidate.get();
        category.setName(updateCategoryDto.name);
        category.setTasks(updateCategoryDto.tasks);
        category.setModifyDate(new Date());

        categoryRepo.save(category);
        return "Категория успешно обновлена";
    }

    @Override
    public String deleteCategoryById(Long id) {
        var candidate = categoryRepo.findById(id);

        if (candidate.isEmpty())
            return "Категория с таким id не существует";

        categoryRepo.deleteById(id);

        return "Категория успешно удалена";
    }
}
