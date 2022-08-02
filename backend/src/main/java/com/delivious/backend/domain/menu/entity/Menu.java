package com.delivious.backend.domain.menu.entity;

import com.delivious.backend.domain.category.entity.Category;
import com.delivious.backend.domain.menu.dto.MenuRequest;
import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.global.common.BaseEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "menus")
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "menu_id")
    private UUID id;

    @NotNull
    @Column(name = "menu_name")
    private String menuName;

    @NotNull
    private Float price;

    @NotNull
    @Column(name = "menu_image")
    private String menuImage;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @NotNull
    private String temperature;

    @Enumerated(EnumType.STRING)
    private Size size;

    @NotNull
    private String description;

    @Builder
    public Menu(Category category, String menuName, Float price, String menuImage, String temperature, Size size, String description) {
        this.menuName = menuName;
        this.price = price;
        this.menuImage = menuImage;
        this.category = category;
        this.temperature = temperature;
        this.size = size;
        this.description = description;
    }

    public void updateMenu(MenuRequest menuRequest) {
        this.menuName = menuRequest.getMenuName();
        this.price = menuRequest.getPrice();
        this.menuImage = menuRequest.getMenuImage();
        this.category = menuRequest.getCategory();
        this.temperature = menuRequest.getTemperature();
        this.size = menuRequest.getSize();
        this.description = menuRequest.getDescription();
    }

    public void removeMenu() {
        // TODO
    }
}
