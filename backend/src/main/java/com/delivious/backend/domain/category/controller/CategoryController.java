package com.delivious.backend.domain.category.controller;

import com.delivious.backend.domain.category.dto.CategoryRequest;
import com.delivious.backend.domain.category.dto.CategoryResponse;
import com.delivious.backend.domain.category.entity.Category;
import com.delivious.backend.domain.category.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody @Valid CategoryRequest categoryRequest) {
        categoryService.createNewCategory(categoryRequest);

        return ResponseEntity.ok(CategoryResponse.of(categoryService.createNewCategory(categoryRequest)));
//        return ResponseEntity.status(HttpStatus.CREATED).body(categoryService.createNewCategory(categoryRequest));
    }

    @GetMapping
    public List<Category> findAllCategory(){

        return categoryService.findAllCategory();
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> findCategory(@PathVariable UUID categoryId) {
        return ResponseEntity.ok(CategoryResponse.of(categoryService.findCategoryById(categoryId)));
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<HttpStatus> updateCategory(@Valid @RequestBody CategoryRequest categoryRequest,
                                                     @PathVariable UUID categoryId) {
        Category category = categoryService.findCategoryById(categoryId);
        categoryService.updateCategory(category, categoryRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable UUID categoryId) {
        Category category = categoryService.findCategoryById(categoryId);

        categoryService.removeCategory(category);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
