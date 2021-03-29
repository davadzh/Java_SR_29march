package com.example.java_sr_29m.Controllers;

import com.example.java_sr_29m.BLL.Services.CategoryService.ICategoryService;
import com.example.java_sr_29m.DAL.Entities.Category;
import com.example.java_sr_29m.DTO.CategoryDtos.CreateCategoryDto;
import com.example.java_sr_29m.DTO.CategoryDtos.UpdateCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/category")
public class CategoryController {
    private final ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(value = "/getcategories")
    public ResponseEntity<List<Category>> GetAllCategories() {
        List<Category> allCategories = categoryService.getCategories();

        return new ResponseEntity<>(allCategories, HttpStatus.OK);
    }

    @PostMapping(value = "/createcategory")
    public ResponseEntity<String> CreateCategory(@RequestBody CreateCategoryDto createCategoryDto) {
        String message = categoryService.addCategory(createCategoryDto);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletecategorybyid")
    public ResponseEntity<String> DeleteCategoryById(@RequestBody Long id) {
        String message = categoryService.deleteCategoryById(id);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping(value = "/updatecategory")
    public ResponseEntity<String> UpdateCategory(@RequestBody UpdateCategoryDto updateCategoryDto) {
        String message = categoryService.updateCategory(updateCategoryDto);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
