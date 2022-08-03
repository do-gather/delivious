package com.delivious.backend.domain.category.controller;

import com.delivious.backend.domain.category.dto.CategoryRequest;
import com.delivious.backend.domain.category.dto.CategoryResponse;
import com.delivious.backend.domain.category.entity.Category;
import com.delivious.backend.domain.category.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CategoryResponse.of(categoryService.createNewCategory(categoryRequest)));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAllCategory(
            @RequestParam(value = "store-id") UUID storeId,
            @RequestParam(value = "category-name", required = false) String categoryName) {
        List<Category> categories = categoryService.searchCategories(storeId, categoryName);
        List<CategoryResponse> result = categories.stream().map(CategoryResponse::of).collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> findCategory(@PathVariable UUID categoryId) {
        return ResponseEntity.ok(CategoryResponse.of(categoryService.findCategoryById(categoryId)));
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<HttpStatus> updateCategory(@Valid @RequestBody CategoryRequest categoryRequest,
                                                     @PathVariable UUID categoryId) {
        categoryService.updateCategory(categoryId, categoryRequest);
        return ResponseEntity.ok()
                .build();
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable UUID categoryId) {
        categoryService.removeCategory(categoryId);
        return ResponseEntity.noContent().build();
    }
}
