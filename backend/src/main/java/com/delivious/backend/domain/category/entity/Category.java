package com.delivious.backend.domain.category.entity;

import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.domain.users.entity.Store;
import com.delivious.backend.global.common.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "category")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "category_id")
    private UUID id;

    @NotNull
    @Column(name = "category_name")
    private String categoryName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Store store;

    @OneToMany(mappedBy = "category",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Menu> menus = new LinkedHashSet<>();

    public Category(String categoryName, Store store) {
        this.categoryName = categoryName;
        this.store = store;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
        menu.setCategory(this);
    }

    public void deleteMenu(Menu menu) {
        menus.remove(menu);
        menu.setCategory(null);
    }

    public void update(String categoryName) {
        this.categoryName = categoryName;
    }
}