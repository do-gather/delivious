package com.delivious.backend.domain.menu.service;

import com.delivious.backend.domain.menu.dto.CategoryDto;
import com.delivious.backend.domain.menu.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public CategoryDto insertCategory(CategoryDto category) {
        return categoryRepository.insertCategory(category);
    }

    public List<CategoryDto> getAllCategorys() {
        return categoryRepository.getAllCategorys();
    }

    public CategoryDto getCategoryByCategoryName(String category_name) {
        return categoryRepository.getCategoryByCategoryName(category_name);
    }
    // update -> delete 와 같은 방식

    public void deleteCategory(String category_name) {
        categoryRepository.deletCategory(category_name);
    }
}
