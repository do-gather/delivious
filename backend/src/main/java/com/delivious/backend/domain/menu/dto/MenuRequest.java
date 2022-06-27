package com.delivious.backend.domain.menu.dto;

import com.delivious.backend.domain.category.entity.Category;
import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.entity.Size;
import lombok.*;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MenuRequest {

    private String menuName;
    private Float price;
    private String menuImage;
//    private UUID categoryId;
    private Category category;
//    private Category categoryName;
    private String temperature;
    private Size size;
    private String description;

    public Menu toEntity() {
        return Menu.builder()
                .menuName(menuName)
                .price(price)
                .menuImage(menuImage)
                .category(category)
                .temperature(temperature)
                .size(size)
                .description(description)
                .build();
    }
}
