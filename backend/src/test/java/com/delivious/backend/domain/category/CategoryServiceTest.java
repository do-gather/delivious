package com.delivious.backend.domain.category;

import com.delivious.backend.domain.category.dto.CategoryRequest;
import com.delivious.backend.domain.category.entity.Category;
import com.delivious.backend.domain.category.exception.CategoryNotFoundException;
import com.delivious.backend.domain.category.repository.CategoryRepository;
import com.delivious.backend.domain.category.service.CategoryService;
import com.delivious.backend.domain.category.service.CategoryServiceImpl;
import com.delivious.backend.domain.users.dto.UserDto;
import com.delivious.backend.domain.users.dto.UserResponseDto;
import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.domain.users.entity.User;
import com.delivious.backend.domain.users.repository.StoreRepository;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.persistence.EntityNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private StoreRepository storeRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    private Store store;
    private User user;

    private Category category;

    private CategoryRequest categoryRequest;

    @Autowired
    private MockMvc mockMvc;
    @BeforeEach
    void setUp() {
        categoryService = new CategoryServiceImpl(categoryRepository,storeRepository);
        user = User.builder()
                .username("admin")
                .password("admin")
                .name("관리자")
                .phoneNum("01090551111")
                .birth(null)
                .type("admin")
                .build();

//        UUID storeId = UUID.randomUUID();
        store = Store.builder()
                .user(user)
                .storeName("starbucks")
                .build();

        storeRepository.save(store);

        category = Category.builder()
                .categoryName("coffee")
                .store(store)
                .build();

        categoryRepository.save(category);

        categoryRequest = CategoryRequest.builder()
                .storeId(store.getId())
                .categoryName("coffee")
                .build();

        Category category = new Category(categoryRequest.getCategoryName(), store);
        categoryRepository.save(category);




    }


    @DisplayName("카테고리 생성 테스트")
    @Test
    void When_Create_NewCategory() throws Exception {
        // given
        CategoryRequest categoryRequest = new CategoryRequest(store.getId(), "coffee");
        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        // when
        Category createNewCategory = categoryService.createNewCategory(categoryRequest);

        // then
        verify(categoryRepository, atLeastOnce()).save(any(Category.class));
        assertEquals(createNewCategory, category.getId());

    }


    @DisplayName("카테고리 1건 조회 테스트")
    @Test
    void findCategoryById() {
        // given
        UUID testId = UUID.randomUUID();
        given(categoryRepository.findById(any())).willReturn(Optional.empty());

        assertThrows(CategoryNotFoundException.class,() -> categoryService.findCategoryById(testId));

        verify(categoryRepository).findById(any());
    }

    @DisplayName("카테고리 전체 조회 테스트")
    @Test
    void findCategoryList() {
        List<Category> categories = new ArrayList<>();

        categories.add(new Category("coffee", store));
        given(categoryRepository.findAll()).willReturn(categories);

        List<Category> expected = categoryService.searchCategories(store.getId(),"coffee");

        assertEquals(expected, categories);
        verify(categoryRepository.findAll());
    }

    @Test
    void check() {
        System.out.println(category);
        System.out.println(store.getId());
        System.out.println(category.getStore());
        System.out.println(categoryRequest.getStoreId());
        System.out.println(categoryRequest.getStoreId());
    }
}
