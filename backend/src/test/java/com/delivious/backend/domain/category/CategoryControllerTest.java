package com.delivious.backend.domain.category;

import com.delivious.backend.domain.category.dto.CategoryRequest;
import com.delivious.backend.domain.category.service.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
@WebAppConfiguration
@WebMvcTest
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    void save() throws Exception {
        UUID storeId = UUID.randomUUID();
        CategoryRequest categoryRequest = new CategoryRequest(storeId,"coffee");
        categoryService.createNewCategory(categoryRequest);
        mockMvc.perform(post("/categories"));
    }

}
