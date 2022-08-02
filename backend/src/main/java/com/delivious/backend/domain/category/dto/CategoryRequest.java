package com.delivious.backend.domain.category.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class CategoryRequest {

    @NotNull
    private UUID storeId;

    @NotEmpty
    private String categoryName;
}
