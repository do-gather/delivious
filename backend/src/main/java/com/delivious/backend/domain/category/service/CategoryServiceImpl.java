package com.delivious.backend.domain.category.service;

import com.delivious.backend.domain.category.dto.CategoryRequest;
import com.delivious.backend.domain.category.dto.CategoryUpdateRequest;
import com.delivious.backend.domain.category.entity.Category;
import com.delivious.backend.domain.category.exception.CategoryDuplicateException;
import com.delivious.backend.domain.category.exception.CategoryNotFoundException;
import com.delivious.backend.domain.category.repository.CategoryRepository;
import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.exception.StoreIdNotFoundException;
import com.delivious.backend.domain.users.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Category createNewCategory(CategoryRequest categoryRequest) {
        if (categoryRepository.existsByCategoryNameAndStoreId(categoryRequest.getCategoryName(), categoryRequest.getStoreId())) {
            throw new CategoryDuplicateException();
        }

        Store store = storeRepository.findById(categoryRequest.getStoreId())
                .orElseThrow(() -> new StoreIdNotFoundException(categoryRequest.getStoreId()));

        Category category = new Category(categoryRequest.getCategoryName(), store);
        return categoryRepository.save(category);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> searchCategories(UUID storeId, String categoryName) {
        return categoryRepository.searchCategories(storeId, categoryName);
    }

    @Override
    @Transactional(readOnly = true)
    public Category findCategoryById(UUID id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @Override
    public void updateCategory(UUID categoryId, CategoryUpdateRequest categoryUpdateRequestRequest) {
        Category category = findCategoryById(categoryId);
        category.update(categoryUpdateRequestRequest.getCategoryName());
        categoryRepository.save(category);
    }

    @Override
    public void removeCategory(UUID categoryId) {
        findCategoryById(categoryId);
        categoryRepository.deleteById(categoryId);
    }
}
