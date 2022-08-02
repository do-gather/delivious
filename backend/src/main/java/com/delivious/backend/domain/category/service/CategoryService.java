package com.delivious.backend.domain.category.service;

import com.delivious.backend.domain.category.dto.CategoryRequest;
import com.delivious.backend.domain.category.dto.CategoryUpdateRequest;
import com.delivious.backend.domain.category.entity.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<Category> searchCategories(UUID storeId, String categoryName);

    Category findCategoryById(UUID id);

    Category createNewCategory(CategoryRequest categoryRequest);

    void updateCategory(UUID categoryId, CategoryUpdateRequest categoryUpdateRequest);

    void removeCategory(UUID categoryId);
}