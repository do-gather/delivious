package com.delivious.backend.domain.menu.dto;

import com.delivious.backend.domain.menu.entity.Img;
import com.delivious.backend.domain.menu.entity.Menu;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class MenuUpdateDto {
    private UUID menu_id;
    private Img img;
    private String menu_name;
    private int menu_price;
    private String temperature;
    private String description;

    public static MenuUpdateDto fromEntity(Menu menu) {
        return MenuUpdateDto.builder()
                .menu_id(menu.getMenu_id())
                .img(menu.getImg())
                //.category_id(menu.getCategory().getCategory)id())
                .menu_name(menu.getMenu_name())
                .menu_price(menu.getMenu_price())
                .temperature(menu.getTemperature())
                .description(menu.getDescription())
                .build();
    }
}
