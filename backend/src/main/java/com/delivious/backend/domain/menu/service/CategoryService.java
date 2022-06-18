package com.delivious.backend.domain.menu.service;


import com.delivious.backend.domain.menu.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getSortedMenuCategories();

}