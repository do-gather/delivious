package com.delivious.backend.domain.menu.entity;


import com.delivious.backend.global.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "category")

public class Category extends BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)",name = "category_id")
    private UUID categoryId;

    @NotNull
    @Column(name="category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Menu> menuItemsOfCategory;

    public Category(){

    }

    public Category(@NotNull String categoryName) {
        this.categoryName = categoryName;
    }

    public UUID getCategoryId() {
        return categoryId;
    }


    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Menu> getMenuItemsOfCategory() {
        return menuItemsOfCategory;
    }

    public void setMenuItemsOfCategory(Set<Menu> menuItemsOfCategory) {
        this.menuItemsOfCategory = menuItemsOfCategory;
    }
}
