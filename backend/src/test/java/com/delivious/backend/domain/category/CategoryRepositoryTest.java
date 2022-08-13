package com.delivious.backend.domain.category;

import com.delivious.backend.domain.category.entity.Category;
import com.delivious.backend.domain.category.repository.CategoryRepository;
import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.repository.StoreRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityExistsException;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private StoreRepository storeRepository;

    private Category coffee;
    private Store starbucks;

    @BeforeEach
    void setUp() {
        starbucks = Store.builder()
                .storeName("starbucks")
                .build();

        storeRepository.save(starbucks);

        coffee = Category.builder()
                .categoryName("coffee")
                .store(starbucks)
                .build();

        categoryRepository.save(coffee);
    }

    @DisplayName("카테고리 저장 테스트")
    @Test
    public void createCategory() {
        // given - setUp() -> coffee

        // when
        Category savedCategory = categoryRepository.save(coffee);

        // then
        assertThat(savedCategory.getCategoryName()).isEqualTo(coffee.getCategoryName());
        assertThat(savedCategory.getId()).isEqualTo(coffee.getId());
        assertThat(savedCategory.getStore()).isEqualTo(coffee.getStore());
    }


    @DisplayName("CategoryName으로 카테고리 조회 테스트")
    @Test
    void findByCategoryName_test() {
        Category foundCategory = categoryRepository.findByCategoryName(coffee.getCategoryName()).orElseThrow(EntityExistsException::new);

        assertAll(
                () -> assertEquals(foundCategory, coffee)
        );
    }
}
