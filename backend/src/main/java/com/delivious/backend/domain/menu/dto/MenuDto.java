package com.delivious.backend.domain.menu.dto;

import com.delivious.backend.domain.menu.entity.Size;

import java.util.UUID;

public class MenuDto {

    private UUID menuId;
    private String menuName;
    private Float price;
    private String menuImage;
    private String temperature;
    private Size size;
    private String description;
    private String categoryName;

    public MenuDto() {

    }

    public MenuDto(String menuName, Float price, String menuImage, String temperature, Size size, String description, String categoryName) {
        this.menuName = menuName;
        this.price = price;
        this.menuImage = menuImage;
        this.temperature = temperature;
        this.size = size;
        this.description = description;
        this.categoryName = categoryName;
    }

    public UUID getMenuId() {
        return menuId;
    }

    public void setMenuId(UUID menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getMenuImage() {
        return menuImage;
    }

    public void setMenuImage(String menuImage) {
        this.menuImage = menuImage;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


}
