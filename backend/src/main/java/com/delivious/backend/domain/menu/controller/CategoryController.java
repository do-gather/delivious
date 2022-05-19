package com.delivious.backend.domain.menu.controller;

import com.delivious.backend.domain.menu.dto.CategoryDto;
import com.delivious.backend.domain.menu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorys")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("")
    public CategoryDto insertCategory(@RequestBody CategoryDto category) {
        return categoryService.insertCategory(category);
    }

    @GetMapping("")
    public List<CategoryDto> getAllCategorys() {
        return categoryService.getAllCategorys();
    }

    @GetMapping("/{category_name}")
    public CategoryDto getCategoryByCategoryName(@PathVariable String category_name) {
        return categoryService.getCategoryByCategoryName(category_name);
    }
    // update -> delete 와 같은 방식

    @DeleteMapping("/{category_name}")
    public void deleteCategory(@PathVariable String category_name) {
        categoryService.deleteCategory(category_name);
    }
}
