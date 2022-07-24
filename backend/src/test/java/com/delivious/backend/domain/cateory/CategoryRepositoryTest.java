package com.delivious.backend.domain.cateory;
import com.delivious.backend.domain.category.entity.Category;
import com.delivious.backend.domain.category.repository.CategoryRepository;

import org.junit.After;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @After
    public void cleanup() {
        categoryRepository.deleteAll();
    }

    @Test
    public void 카테고리저장_불러오기() {

        //given
        String categoryName = "CoffeeTest";
        categoryRepository.save(Category.builder().categoryName(categoryName).build());

        //when
        List<Category> categoryList = categoryRepository.findAll();

        //then
        Category category = categoryList.get(0);
        assertThat(category.getCategoryName()).isEqualTo(categoryName);
    }

}


