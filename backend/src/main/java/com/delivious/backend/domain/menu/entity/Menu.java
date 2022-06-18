package com.delivious.backend.domain.menu.entity;
import com.delivious.backend.global.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "menus")
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", name = "menu_id")
    private UUID menuId;

    @NotNull
    @Column(name = "menu_name")
    private String menuName;

    @NotNull
    private Float price;

    @NotNull
    @Column(name = "menu_image")
    private String menuImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonBackReference // 순환참조 방지
    private Category category;

    @Transient //categoryId 제외
    private UUID categoryId;

    @NotNull
    private String temperature;

    @Enumerated(EnumType.STRING)
    private Size size;

    @NotNull
    private String description;

    public Menu() {

    }

    public Menu(String menuName, Float price, String menuImage, String temperature, Size size, String description) {
        this.menuName = menuName;
        this.price = price;
        this.menuImage = menuImage;
        this.temperature = temperature;
        this.size = size;
        this.description = description;
    }

    public UUID getMenuId() {
        return menuId;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public UUID getCategoryId() {
        return getCategory().getCategoryId();
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
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
}