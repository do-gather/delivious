package com.delivious.backend.domain.menu.dto;

import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.menu.entity.Size;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

public class MenuResponseDto {
    private UUID menu_id;
    //category_id // img_id
    private String menu_name;
    private int menu_price;
    private String temperature;
    private String description;

    public MenuResponseDto(Menu entity) {
        this.menu_id = entity.getMenu_id();
        this.menu_price = entity.getMenu_price();
        this.menu_name = entity.getMenu_name();
        this.temperature = entity.getTemperature();
        this.description = entity.getDescription();
    }

}
