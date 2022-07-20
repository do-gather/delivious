package com.delivious.backend.domain.cateory;

import com.delivious.backend.domain.category.dto.CategoryResponse;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryResponseTest {

    @Test
    public void CategoryResponseTest() {
        UUID categoryId = UUID.randomUUID();
        String categoryName = "coffee";

        CategoryResponse dto = new CategoryResponse(categoryId,categoryName);

        assertThat(dto.getCategoryId()).isEqualTo(categoryId);
        assertThat(dto.getCategoryName()).isEqualTo(categoryName);
    }
}
