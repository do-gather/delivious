package com.delivious.backend.domain.menu.service.impl;

import com.delivious.backend.domain.menu.entity.Category;
import com.delivious.backend.domain.menu.repository.CategoryRepository;
import com.delivious.backend.domain.menu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getSortedMenuCategories() {
        return categoryRepository.findByOrderByCategoryNameAsc();

    }
}
