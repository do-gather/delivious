package com.delivious.backend.domain.menu.repository;

import com.delivious.backend.domain.menu.dto.CategoryDto;

import com.delivious.backend.domain.menu.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {

    static public ArrayList<CategoryDto> categorys;

    static {
        categorys = new ArrayList<>();
        categorys.add(new CategoryDto("non-coffee"));
        categorys.add(new CategoryDto("coffee"));
        categorys.add(new CategoryDto("bottle"));
    }


    // list에 data 삽입
    public CategoryDto  insertCategory(CategoryDto category){
        categorys.add(category);
        return category;
    }

    public List<CategoryDto> getAllCategorys(){
        return categorys;
    }

    // 하나만 조회 -> category_name으로
    public CategoryDto getCategoryByCategoryName(String category_name) {
        return categorys.stream()
                .filter(categoryDto -> categoryDto.getCategory_name().equals(category_name))
                .findAny()
                .orElse(new CategoryDto(""));
    }

    // update
    public void updateCategoryName(String category_name) {
        categorys.stream()
                .filter(categoryDto -> categoryDto.getCategory_name().equals(category_name))
                .findAny()
                .orElse(new CategoryDto(""));
//                .setCategory_name(category.getCategory_name);
    }
    public void deletCategory(String category_name) {
        categorys.removeIf(categoryDto -> categoryDto.getCategory_name().equals(category_name));
    }


}
