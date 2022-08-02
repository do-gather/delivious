package com.delivious.backend.domain.category.service;

import com.delivious.backend.domain.category.dto.CategoryRequest;
import com.delivious.backend.domain.category.entity.Category;
import com.delivious.backend.domain.category.exception.CategoryNotFoundException;
import com.delivious.backend.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Category createNewCategory(CategoryRequest categoryRequest) {
        Category category = categoryRequest.toEntity();
//        if (categoryRepository.existsByCategoryName(categoryRequest.getCategoryName())) {
//            throw new
//        }

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Category findCategoryByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName)
                .orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public void updateCategory(Category category, CategoryRequest categoryRequest) {
        category.updateCategory(categoryRequest);
        categoryRepository.save(category);
    }

    @Override
    public void removeCategory(Category category) {
        categoryRepository.delete(category);
    }
}