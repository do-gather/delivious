package com.delivious.backend.domain.menu.controller;

import com.delivious.backend.domain.menu.entity.Category;
import com.delivious.backend.domain.menu.service.CategoryService;
import com.delivious.backend.domain.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menus")
class MenuApiController {

    private final CategoryService categoryService;
    private final MenuService menuService;
    private static final Logger LOGGER = LoggerFactory.getLogger(MenuApiController.class);


    @Autowired
    public MenuApiController(CategoryService categoryService, MenuService menuService) {
        this.categoryService = categoryService;
        this.menuService = menuService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getCategories() {

        return new ResponseEntity<>(categoryService.getSortedMenuCategories(), HttpStatus.OK);
    }
}
