package com.delivious.backend.domain.category.entity;

import com.delivious.backend.domain.category.dto.CategoryRequest;
import com.delivious.backend.domain.menu.entity.Menu;
import com.delivious.backend.global.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "category")

public class Category extends BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", name = "category_id")
    private UUID categoryId;

    @NotNull
    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Menu> menus;

    @Builder
    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public void updateCategory(CategoryRequest categoryRequest){
        this.categoryName = categoryRequest.getCategoryName();
    }

    public void removeCategory() {
    }
}