package com.delivious.backend.domain.menu.dto;

import com.delivious.backend.domain.menu.entity.Img;
import com.delivious.backend.domain.menu.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class MenuSaveDto {
    private UUID menu_id;
    // category img 추가
    private Img img;
    private String menu_name;
    private int menu_price;
    private String temperature;
    private String description;

    public Menu toEntity() {
        return Menu.builder()
                .img(img)
                .menu_name(menu_name)
                .menu_price(menu_price)
                .temperature(temperature)
                .description(description)
                .build();
    }
    public static MenuSaveDto fromEntity(Menu menu) {
        return MenuSaveDto.builder()
                .img(menu.getImg())
                .menu_id(menu.getMenu_id())
                //.category_id(menu.getCategory().getCategory)id())
                .menu_name(menu.getMenu_name())
                .menu_price(menu.getMenu_price())
                .temperature(menu.getTemperature())
                .description(menu.getDescription())
                .build();
    }
}
