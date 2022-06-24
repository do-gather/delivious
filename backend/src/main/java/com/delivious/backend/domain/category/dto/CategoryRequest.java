package com.delivious.backend.domain.category.dto;

import com.delivious.backend.domain.category.entity.Category;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CategoryRequest {

    @NotEmpty
    private String categoryName;

    public Category toEntity() {
        return Category.builder()
                .categoryName(categoryName)
                .build();
    }
}