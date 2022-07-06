package com.delivious.backend.domain.menu.dto;

import com.delivious.backend.domain.category.entity.Category;
import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.entity.Size;
import com.delivious.backend.domain.users.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MenuResponse {

    private UUID menuId;
    private String menuName;
    private Float price;
    private String menuImage;
    //    private UUID categoryId;
    private Category category;
    private Store store;
    private String temperature;
    private Size size;
    private String description;


    public static MenuResponse of(Menu menu) {
        return MenuResponse.builder()
                .menuId(menu.getMenuId())
                .menuName(menu.getMenuName())
                .price(menu.getPrice())
                .menuImage(menu.getMenuImage())
                .category(menu.getCategory())
                .store(menu.getStore())
                .temperature(menu.getTemperature())
                .size(menu.getSize())
                .description(menu.getDescription())
                .build();
    }
}
