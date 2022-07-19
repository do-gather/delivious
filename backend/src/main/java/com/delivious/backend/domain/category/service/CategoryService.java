package com.delivious.backend.domain.category.service;

import com.delivious.backend.domain.category.dto.CategoryRequest;
import com.delivious.backend.domain.category.entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    public List<Category> findAllCategory();

    public Category findCategoryById(UUID categoryId);

    public Category createNewCategory(CategoryRequest categoryRequest);

    public void updateCategory(Category category, CategoryRequest categoryRequest);

    public void removeCategory(Category category);

}